package com.augus.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义错误码
 * @author Augus
 * @date 2018/7/10 13:23
 */
public enum ErrorCodeEnum {

    /**
     * token error
     */
    TOKEN_INVALID(700, "Token is Invalid"),
    /**
     * token expired
     */
    TOKEN_EXPIRED(701, "Token is Expired");

    /**
     *  error code
     */
    private @Getter @Setter int code;
    /**
     * error message
     */
    private @Getter @Setter String message;

    ErrorCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }


    @Override
    public String toString() {
        return "[" + this.code + "]" + this.message;
    }
}
