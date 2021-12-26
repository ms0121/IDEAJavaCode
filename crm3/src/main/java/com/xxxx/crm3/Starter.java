package com.xxxx.crm3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lms
 * @date 2021-09-27 - 16:41
 */
@SpringBootApplication
@MapperScan("com.xxxx.crm3.dao")
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
