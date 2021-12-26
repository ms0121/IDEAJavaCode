package com.liu.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liu.security.mapper")
public class Security01Application {

	public static void main(String[] args) {
		SpringApplication.run(Security01Application.class, args);
	}

}
