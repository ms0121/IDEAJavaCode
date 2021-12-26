package com.liu.jwt.config;

import com.liu.jwt.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lms
 * @date 2021-10-02 - 10:29
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                // 拦截所有的请求信息
                .addPathPatterns("/**")
                // 只放行/login登录请求，
                .excludePathPatterns("/login");
    }
}
