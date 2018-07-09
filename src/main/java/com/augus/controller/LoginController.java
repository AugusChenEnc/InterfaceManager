package com.augus.controller;

import com.alibaba.fastjson.JSON;
import com.augus.annotation.IgnoreSecurity;
import com.augus.common.StandardResponse;
import com.augus.exception.TokenException;
import com.augus.pojo.Users;
import com.augus.service.UserService;
import com.augus.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Login Controller
 * @author Augus
 * @date 2018/07/06
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @IgnoreSecurity
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public StandardResponse login(@RequestBody Users users){
        StandardResponse response = new StandardResponse();
        users = userService.findUsersByAccountAndPassword(users);
        String token = "";
        if (users != null) {
            try {
                token = JwtTokenUtil.createToken(users.getId());
            } catch (Exception e) {
                throw new TokenException("Create Token error :" + e);
            }
        }
        log.info("查询成功" + users.toString());

        return response.success("{\"token\": \""+token+"\",\"account\":\""+ users.getAccount() +"\"}");
    }

}
