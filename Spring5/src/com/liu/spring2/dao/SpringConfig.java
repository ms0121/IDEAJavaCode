package com.liu.spring2.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-04-11 - 16:02
 */
// 使用完全注解的方式代替xml配置文件的方式进行注解开发
@Configuration  // 作为配置类，用于替代xml配置文件
@ComponentScan(basePackages = {"com.liu.spring2"})
public class SpringConfig {

}
