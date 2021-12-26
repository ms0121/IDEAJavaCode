package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author lms
 * @date 2021-11-04 - 21:29
 */
@SpringBootApplication
@EnableConfigurationProperties
@ConditionalOnWebApplication
public class JdApplication {
    public static void main(String[] args) {
        SpringApplication.run(JdApplication.class, args);
    }
}
