package com.augus.common;

import lombok.Data;

/**
 * @author Augus
 * @date 2018/7/5 16:59
 */
@Data
public class StandardResponse {

    private Meta meta;
    private Object data;

    public StandardResponse success(Object data){
        this.meta = new Meta(200, "ok");
        this.data = data;
        return this;
    }

    public StandardResponse failure(String message){
        this.meta = new Meta(404, message);
        this.data = null;
        return this;
    }

    public StandardResponse failure(Integer statusCode, String message){
        this.meta = new Meta(statusCode, message);
        this.data = null;
        return this;
    }

    public StandardResponse failure(ErrorCodeEnum errorCodeEnum){
        this.meta = new Meta(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
        this.data = null;
        return this;
    }

    @Data
    class Meta{
        private Integer statusCode;
        private String message;

        public Meta(){}
        public Meta(Integer statusCode, String message){
            this.statusCode = statusCode;
            this.message = message;
        }
    }

}
