package com.liu.session.config;

import com.liu.session.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lms
 * @date 2021-10-02 - 19:40
 */

@Configuration
public class SessionConfig implements WebMvcConfigurer {

    // 因为要使用自定义的拦截器
    @Autowired
    private SessionInterceptor sessionInterceptor;

    // 添加配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**") // 拦截所有的请求
                .excludePathPatterns("/index", "/logout")  // 不拦截表单提交请求
                .excludePathPatterns("/login");  // 不拦截登录请求

    }
}
