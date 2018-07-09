package com.augus.exception;

import lombok.Data;

/**
 * token异常
 * @author Augus
 * @date 2018/7/9 15:09
 */
@Data
public class TokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    public TokenException(String msg) {
        this.msg = msg;
    }

}
