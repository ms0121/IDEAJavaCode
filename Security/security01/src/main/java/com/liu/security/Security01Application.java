package com.liu.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan("com.liu.security.mapper")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security01Application {

	public static void main(String[] args) {
		SpringApplication.run(Security01Application.class, args);
	}

}
