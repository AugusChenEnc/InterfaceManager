package com.augus.utils.entity;

import lombok.Data;

/**
 * TokenJWT class
 * @author Augus
 * @date 2018/7/9 10:27
 */
@Data
public class TokenJwt {

    /**
     * Header
     */
    private TokenHeader tokenHeader;
    /**
     * PlayLoad
     */
    private TokenPlayLoad tokenPlayLoad;
    /**
     * 签名
     */
    private String signature;

}
