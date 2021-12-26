package com.liu.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.liu.boot.mapper")
@SpringBootApplication
public class Boot05AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot05AdminApplication.class, args);
    }

}
