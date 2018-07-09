package com.augus.utils;

import com.alibaba.fastjson.JSON;
import com.augus.utils.entity.TokenJwt;
import com.augus.utils.entity.TokenHeader;
import com.augus.utils.entity.TokenPlayLoad;

/**
 * Token Generate Tool
 * @author Augus
 * @date 2018/7/6 17:12
 */
public class TokenUtil {

    private static final String TOKEN_AES_KEY = "AugusInterfaceManagerToken";
    private static final String JWT_TYP = "JWT";
    private static final String JWT_ALG = "AES";
    private static final String JWT_ISS = "Augus";
    private static final String JWT_EXP = "30";

    public static void main(String[] args){
        try {
            String token = generateToken("123456");
            System.out.println(token);
            System.out.println(verifyJWT(token));

            TokenJwt tokenJwt = decryptTokenJwt(token);
            System.out.println(JSON.toJSONString(tokenJwt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate Token
     * @param data
     * @return
     * @throws Exception
     */
    public static String generateToken(String data) throws Exception {
        TokenPlayLoad userTokenPlayLoad = new TokenPlayLoad();
        userTokenPlayLoad.setExpData(data);
        return createJWT(userTokenPlayLoad);
    }

    /**
     * Generate JWT
     * @param tokenPlayLoad
     * @return
     * @throws Exception
     */
    private static String createJWT(TokenPlayLoad tokenPlayLoad) throws Exception {
        StringBuffer jwtSb = new StringBuffer();
        StringBuffer headerPlayLoadSb = new StringBuffer();

        String tokenHeaderBase64 = tokenHeaderBase64();
        String tokenPlayLoadBase64 = tokenPlayLoadBase64(tokenPlayLoad);

        jwtSb.append(tokenHeaderBase64).append(".");
        jwtSb.append(tokenPlayLoadBase64).append(".");
        headerPlayLoadSb.append(tokenHeaderBase64);
        headerPlayLoadSb.append(tokenPlayLoadBase64);

        String headerPlayLoadSalt = SaltUtil.addSalt(headerPlayLoadSb.toString());
        String key = AesUtil.initKey(TOKEN_AES_KEY);
        String signature = Base64Util.encryptBASE64(AesUtil.encrypt(headerPlayLoadSalt.getBytes(),key));
        jwtSb.append(signature);
        return Base64Util.encryptBASE64(jwtSb.toString().getBytes());
    }

    /**
     * 校验token是否是服务器生成的，以防token被修改
     * @param jwtBase64
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> boolean verifyJWT(String jwtBase64) throws Exception {
        String jwt = new String(Base64Util.decryptBASE64(jwtBase64));
        String containsChar = ".";
        int contentLength = 3;

        if (!jwt.contains(containsChar)) {
            return false;
        }
        /**
         * contentLength equals three
         * 1、Header
         * 2、Payload
         * 3、Signature
         */
        String[] jwtStr = jwt.split("\\.");
        if (jwtStr.length < contentLength){
            return false;
        }

        String key = AesUtil.initKey(TOKEN_AES_KEY);

        //解析出header跟playLoad
        StringBuffer headerPlayLoadSb = new StringBuffer();
        headerPlayLoadSb.append(jwtStr[0]);
        headerPlayLoadSb.append(jwtStr[1]);

        //解析signature
        String  headerPlayLoadSalt = new String (AesUtil.decrypt(Base64Util.decryptBASE64(jwtStr[2]),key));
        return SaltUtil.verifyPwd(headerPlayLoadSb.toString(),headerPlayLoadSalt);
    }

    /**
     * 生成jwt的header部分内容
     * @return
     * @throws Exception
     */
    private static String tokenHeaderBase64(){
        TokenHeader tokenHeader =  new TokenHeader();
        tokenHeader.setTyp(JWT_TYP);
        tokenHeader.setAlg(JWT_ALG );
        String headerJson = JSON.toJSONString(tokenHeader);
        return Base64Util.encryptBASE64(headerJson.getBytes());
    }

    /**
     * 生成jwt的payload部分内容
     * @param tokenPlayLoad
     * @return
     */
    private static String tokenPlayLoadBase64(TokenPlayLoad tokenPlayLoad){
        tokenPlayLoad.setIss(JWT_ISS);
        tokenPlayLoad.setExp(JWT_EXP);
        tokenPlayLoad.setIat(String.valueOf(System.currentTimeMillis()));
        String playLoadJson = JSON.toJSONString(tokenPlayLoad);
        return Base64Util.encryptBASE64(playLoadJson.getBytes());
    }

    /**
     * 解密Token
     * @param data
     * @return
     * @throws Exception
     */
    public static TokenJwt decryptTokenJwt(String data) throws Exception {
        String jwt = new String(Base64Util.decryptBASE64(data));

        TokenJwt tokenJwt = null;
        String containsChar = ".";
        int contentLength = 3;

        if (!jwt.contains(containsChar)) {
            return tokenJwt;
        }

        /**
         * contentLength equals three
         * 1、Header
         * 2、Payload
         * 3、Signature
         */
        String[] jwtStr = jwt.split("\\.");
        if (jwtStr.length < contentLength){
            return tokenJwt;
        }

        tokenJwt = new TokenJwt();
        tokenJwt.setTokenHeader(decryptTokenHeader(jwtStr[0]));
        tokenJwt.setTokenPlayLoad(decryptTokenPlayLoad(jwtStr[1]));
        tokenJwt.setSignature(jwtStr[2]);
        return tokenJwt;
    }

    /**
     * 解密tokenHeader
     * @param data
     * @return
     * @throws Exception
     */
    public static TokenHeader decryptTokenHeader(String data) throws Exception {
        if (data.isEmpty()) {
            return null;
        }
        return JSON.parseObject(new String(Base64Util.decryptBASE64(data)), TokenHeader.class);
    }

    /**
     * 解密tokenPlayLoad
     * @param data
     * @return
     * @throws Exception
     */
    public static TokenPlayLoad decryptTokenPlayLoad(String data) throws Exception {
        if (data.isEmpty()) {
            return null;
        }
        return JSON.parseObject(new String(Base64Util.decryptBASE64(data)), TokenPlayLoad.class);
    }

}
