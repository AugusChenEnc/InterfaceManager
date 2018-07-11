package com.augus.aspect;

import com.augus.common.ErrorCodeEnum;
import com.augus.common.StandardResponse;
import com.augus.exception.TokenException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * 连接响应异常
 * @author Augus
 * @date 2018/7/9 15:12
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAspect {

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public StandardResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("could_not_read_json...", e);
        return new StandardResponse().failure(400,"could_not_read_json");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public StandardResponse handleValidationException(MethodArgumentNotValidException e) {
        log.error("parameter_validation_exception...", e);
        return new StandardResponse().failure(400,"parameter_validation_exception");
    }

    /**
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public StandardResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("request_method_not_supported...", e);
        return new StandardResponse().failure(405,"request_method_not_supported");
    }

    /**
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
    public StandardResponse handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("content_type_not_supported...", e);
        return new StandardResponse().failure(415,"content_type_not_supported");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TokenException.class)
    public StandardResponse handleTokenException(Exception e) {
        log.error("Token is invalid...", e);
        return new StandardResponse().failure(ErrorCodeEnum.TOKEN_INVALID);
    }

    /**
     * 500 - Token is Expired
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TokenExpiredException.class)
    public StandardResponse handleTokenExpiredException(Exception e) {
        log.error("Token is Expired...", e);
        return new StandardResponse().failure(ErrorCodeEnum.TOKEN_EXPIRED);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public StandardResponse handleException(Exception e) {
        log.error("Internal Server Error...", e);
        return new StandardResponse().failure(500,"Internal Server Error");
    }

}
