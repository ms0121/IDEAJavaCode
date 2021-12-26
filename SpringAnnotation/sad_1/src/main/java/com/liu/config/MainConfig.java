package com.liu.config;

import com.liu.bean.Person;
import com.liu.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.AnnotatedArrayType;

/**
 * @author lms
 * @date 2021-05-07 - 9:00
 *
 * 配置类  ==  配置文件
 *
 * @ComponentScan： value：表示要扫描的包
 * excludeFilters = Filter[]， 指定扫描的时候按照什么规则排除哪些插件
 * includeFilters = Filter[]， 指定扫描的时候只需要包含哪些组件,使用它还需要设置useDefaultFilters=false，
 *                  表示只会扫描指定的注解信息
 *     FilterType.ANNOTATION:按照注解进行扫描
 *     FilterType.ASSIGNABLE_TYPE： 按照给定的类型(使用: 类.class)
 *     FilterType.ASPECTJ： 使用aspectj表达式
 *     FilterType.REGEX:按照正则表达式
 *     FilterType.CUSTOM: 使用自定义的规则
 */

@Configuration   // 告诉spring这是一个配置类
// 配置包扫描的方式 , 根据需要设置不需要扫描的注解,相当于配置文件中的不扫描哪个注解，excludeFilters是一个数组
// 当前是不扫描 controller注解，和service的注解
@ComponentScan(value = "com.liu", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
}, useDefaultFilters = false)
public class MainConfig {
    // 相当于在spring容器中注入相应的对象
    // 给spring容器中注入一个bean，类型为返回值的类型（如Person），id默认使用是方法名作为id，可以使用Bean的属性进行设置
    @Bean("person")  // 等同于配置文件中的bean标签，里面的"person等同于之前的id属性值"
    public Person person01(){
        return new Person("lisi", 20);
    }
}
