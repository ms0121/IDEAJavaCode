package com.liu.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author lms
 * @date 2021-10-02 - 8:46
 *
 * jwt工具类
 */
public class JwtUtils {

    // sign
    private static final String SIGN = "token@lms";


    // 生成token，header.payload.sign
    public static String getToken(Map<String, String> map){

        // 创建jwt builder对象
        JWTCreator.Builder builder = JWT.create();

        // 添加payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        // 设置过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        // 设置过期时间和添加签名信息
        String token = builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }

    // 验证token的合法性
    public static void verify(String token){
        // 如果验证失败会直接抛出异常信息
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }


    // 获取token中的信息
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }
}
