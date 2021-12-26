package com.liu.config;

import com.liu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lms
 * @date 2021-05-07 - 16:32
 */
// 指明外部文件的位置，就相当于配置文件中指定properties文件的路径
@PropertySource(value = "classpath:person.properties")
@Configuration  // 注明该类属于配置类
public class MainConfigOfPropertyValues {

    // 给ioc容器注入一个bean对象
    @Bean
    public Person person(){
        return new Person();
    }
}
