package com.liu.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lms
 * @date 2021-10-04 - 19:16
 * token管理器
 */
@Component
public class TokenManager {

    // 设置token的有效时间(一天)
    private long tokenExpiredTime = 24*60*60*1000;

    // 设置签名
    private String tokenSignKey = "123456";

    // 1. 生成token令牌
    public String create(String username){
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiredTime))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    // 2. 对token进行解析得到用户信息
    public String getUserInfo(String token){
        String username = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return username;
    }

    // 3. 删除token（可以不删除）
    public void removeToken(String token){
    }

}
