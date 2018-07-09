package com.augus.aspect;

import com.augus.annotation.IgnoreSecurity;
import com.augus.exception.TokenException;
import com.augus.utils.JwtTokenUtil;
import com.augus.utils.WebContextUtil;
import com.augus.utils.entity.Constants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * 安全拦截类
 * @author Augus
 * @date 2018/7/9 14:27
 */
@Slf4j
@Aspect
@Configuration
public class SecurityAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {

        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        log.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();

        boolean flag = method.isAnnotationPresent(IgnoreSecurity.class);
        log.debug("Method : " + method.getName() + " : " + flag);
        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if (flag) {
            return pjp.proceed();
        }

        // 从 request header 中获取当前 token
        String token = WebContextUtil.getRequest().getHeader(Constants.DEFAULT_TOKEN_NAME);
        // 检查 token 有效性
        if (!JwtTokenUtil.checkToken(token)) {
            String message = String.format("token [%s] is invalid", token);
            log.debug("message : " + message);
            throw new TokenException(message);
        }

        // 调用目标方法
        return pjp.proceed();
    }

}
