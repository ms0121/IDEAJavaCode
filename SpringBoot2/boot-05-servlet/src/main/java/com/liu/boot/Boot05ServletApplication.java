package com.liu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 方式一：使用
//@ServletComponentScan("com.liu.boot.servlet")
public class Boot05ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot05ServletApplication.class, args);
    }

}
