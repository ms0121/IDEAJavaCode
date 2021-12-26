package com.liu.boot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author lms
 * @date 2021-05-22 - 10:56
 * 设置字符编码的配置类现象
 */

//@Configuration
public class EncodingConfig {

    // 将系统写好的字符过滤器的组件注入到容器当中
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        // 创建字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        // 强制设置使用的编码编码格式
        characterEncodingFilter.setForceEncoding(true);
        // 设置指定的字符编码
        characterEncodingFilter.setEncoding("utf-8");

        // 过滤器注册的bean对象,将相当于之前的web.xml配置文件，装入CharacterEncodingFilter
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 设置字符编码过滤器
        filterRegistrationBean.setFilter(characterEncodingFilter);
        // 设置字符编码作用的路径信息,还需要在核心配置文件中关闭编码的格式
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

}
