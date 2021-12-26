package com.liu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.liu.boot.servlet")
public class Boot07EncodingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot07EncodingApplication.class, args);
    }

}
