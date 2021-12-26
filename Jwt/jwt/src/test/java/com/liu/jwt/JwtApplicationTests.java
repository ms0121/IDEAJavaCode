package com.liu.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

class JwtApplicationTests {

	/**
	 * 生成token信息
	 */
	@Test
	void createToken(){
		// 指定token的过期时间,30s
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND,  60);

		String token = JWT.create()
				// 载荷：设置一些自定义的信息，比如用户名和用户id等等
				.withClaim("userName", "zhangsan")
				.withClaim("id", 10001)
				// 设置当前的token的过期时间
				.withExpiresAt(calendar.getTime())
				// 设置签名，使用的加密协议，密保
				.sign(Algorithm.HMAC256("token@lms"));

		System.out.println("token = " + token);
	}


	/**
	 * 验证token
	 */
	@Test
	void contextLoads() {
		// 创建验证对象
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("token@lms")).build();
		// 使用验证对象解析token
		DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAwMDEsInVzZXJOYW1lIjoiemhhbmdzYW4iLCJleHAiOjE2MzMxMzQ2NDh9.VHDPGP2PePFDolRoDukY7riQ8Rrgt2uwCsXb0R-UVP0");
				// 从解析出来的对象中获取token中封装的username和id
		// 获取令牌的过期时间
		System.out.println("verify.getClaim(\"username\") = " + verify.getClaim("userName").asString());
		System.out.println("verify.getClaim(\"id\") = " + verify.getClaim("id").asInt());
	}

}
