package com.liuboot.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lms
 * @date 2021-09-26 - 19:02
 */
//注明当前的类是配置类
@Configuration
//就等价于applicationContext.xml中配置的包扫描路径
@ComponentScan("com.liuboot.boot")
@PropertySource(value = {"classpath:application.properties"})
public class IocConfig {
    // 获取配置文件中属性的值
    @Value("${user.username}")
    private String name;

    @Value("${user.userage}")
    private Integer age;

    public void test(){
        System.out.println("name: " + name + ", age: " + age);
    }

}
