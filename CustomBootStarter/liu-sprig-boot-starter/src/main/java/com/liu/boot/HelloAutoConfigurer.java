package com.liu.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-11-09 - 19:53
 * 作用:这个是真正的将HelloService(业务类)进行组装属性,然后将其注入到容器的类
 */
@Configuration
// 表示只有在web环境下启用
@ConditionalOnWebApplication
// 启动 HelloProperties.class 类，然后将其注入到容器中
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfigurer {

    @Autowired
    private HelloProperties helloProperties;

    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService(helloProperties);
        helloService.sayHello();
        return helloService;
    }
}
