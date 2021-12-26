package com.liu.boot.config;

import com.liu.boot.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lms
 * @date 2021-05-21 - 15:28
 * 定义此类为配置文件类，等价于之前的xml文件，要实现登录拦截器还要实现
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 该方法等价于之前的 mvc:Interceptors
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 等价于之前的bean，即 < mvc:Interceptors bean class="">
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/user/*")  // 拦截所有的请求
                .excludePathPatterns("/user/error", "/user/login");  // 放行的请求
    }
}
