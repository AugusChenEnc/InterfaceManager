package com.augus.utils.entity;

import lombok.Data;

/**
 * 载荷就是存放有效信息的地方。这个名字像是特指飞机上承载的货品，这些有效信息包含三个部分
 * 1，标准中注册的声明
 * 2，公共的声明
 * 3，私有的声明
 * 标准中注册的声明 (建议但不强制使用) ：
 * iss: jwt签发者
 * sub: jwt所面向的用户
 * aud: 接收jwt的一方
 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
 * nbf: 定义在什么时间之前，该jwt都是不可用的.
 * iat: jwt的签发时间
 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放
 * @author Augus
 * @date 2018/7/6 17:31
 */
@Data
public class TokenPlayLoad {

    /**
     * jwt签发者
     */
    private String iss;
    /**
     * jwt所面向的用户
     */
    private String sub;
    /**
     * 接收jwt的一方
     */
    private String aud;
    /**
     * jwt的过期时间，这个过期时间必须要大于签发时间
     */
    private String exp;
    /**
     * 定义在什么时间之前，该jwt都是不可用的.
     */
    private String nbf;
    /**
     * jwt的签发时间
     */
    private String iat;
    /**
     * jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     */
    private String jti;
    /**
     * 拓展数据
     */
    private String expData;

}
