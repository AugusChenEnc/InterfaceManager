package com.augus.utils;

import com.alibaba.druid.util.StringUtils;
import com.augus.exception.TokenException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import jdk.nashorn.internal.parser.Token;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT规范 Token
 * @author Augus
 * @date 2018/7/9 11:34
 */
public class JwtTokenUtil {


    /** token秘钥，请勿泄露，请勿随便修改 */
    public static final String SECRET = "Interface8Manager8Token";
    /** token 过期时间: 30分钟 */
    public static final int CALENDAR_FIELD = Calendar.MINUTE;
    public static final int CALENDAR_INTERVAL = 30;

    /**
     * JWT生成Token.<br/>
     * JWT构成: header, payload, signature
     * @param data
     * @return
     * @throws Exception
     */
    public static String createToken(String data) {
        try {
            Date iatDate = new Date();
            Date expiresDate = DateUtil.getExpiresDate(CALENDAR_FIELD, CALENDAR_INTERVAL);

            // header Map
            Map<String, Object> map = new HashMap<>(16);
            map.put("alg", "HS256");
            map.put("typ", "JWT");

            /**
             *  header (头部)
             *  withHeader : header
             *  payload (中部)
             *  withKeyId： key 编号
             *  withIssuer: 签发者
             *  withSubject: 面向的用户
             *  withAudience： 接收方
             *  withExpiresAt: 过期时间
             *  withNotBefore：定义在什么时间之前，该jwt都是不可用的
             *  withIssuedAt： jwt的签发时间
             *  withJWTId： jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
             *  withClaim : data
             *  sign
             *  sign: sign
             */
            String token = JWT.create().withHeader(map)
                    .withIssuer("Service")
                    .withIssuedAt(iatDate)
                    .withExpiresAt(expiresDate)
                    .withClaim("data", data)
                    .sign(Algorithm.HMAC256(SECRET));

            return token;
        } catch (UnsupportedEncodingException e) {
            throw new TokenException("Token Generate Error: " + e);
        }
    }

    /**
     * 解密Token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaims();
    }

    /**
     * 检查Token是否正常
     * @param token
     * @return
     */
    public static Boolean checkToken(String token) throws UnsupportedEncodingException {
        if (token == null ) { return false; }

        Map<String, Claim> claims = verifyToken(token);
        Claim expData = claims.get("data");
        if (null == expData || StringUtils.isEmpty(expData.asString())) {
            return false;
        }
        return true;
    }

    /**
     * 获取存放进去的数据
     * 例如：编号，用户名，等..
     * @return
     */
    public static String getExpData(String token) throws UnsupportedEncodingException {
        Map<String, Claim> claims = verifyToken(token);
        Claim expData = claims.get("data");
        if (null == expData || StringUtils.isEmpty(expData.asString())) {
            throw new TokenException("Token format error");
        }
        return expData.asString();
    }

}
