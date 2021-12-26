package com.liu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 方式一：使用注解的实现，
@ServletComponentScan("com.liu.boot.filter")
public class Boot06FilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot06FilterApplication.class, args);
    }

}
