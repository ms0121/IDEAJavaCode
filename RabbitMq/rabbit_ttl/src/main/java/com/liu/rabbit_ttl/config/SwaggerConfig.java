package com.liu.rabbit_ttl.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lms
 * @date 2021-09-16 - 10:18
 */
//配置类
@Configuration
// 开启swagger调试的功能
@EnableSwagger2
public class SwaggerConfig {

    // 相当于bean.xml配置文件
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()


                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("rabbitmq  接口文档")
                .description(" 本文档描述了 rabbitmq  微服务接口定义")
                .version("1.0")
                .contact(new Contact("enjoy888", "http://atguigu.com", "1132601565@qq.com"))
                .build();
    }
}
