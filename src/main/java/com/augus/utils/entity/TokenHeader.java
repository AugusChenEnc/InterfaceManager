package com.augus.utils.entity;

import lombok.Data;

/**
 * jwt的头部承载两部分信息：
 * 1,声明类型，这里是jwt
 * 2,声明加密的算法 通常直接使用 HMAC SHA256
 * @author Augus
 * @date 2018/7/6 17:33
 */
@Data
public class TokenHeader {

    /**
     * 声明类型
     */
    private String typ;
    /**
     * 声明加密的算法 通常直接使用 HMAC SHA256
     */
    private String alg;

}
