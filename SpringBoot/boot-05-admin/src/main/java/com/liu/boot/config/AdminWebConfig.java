package com.liu.boot.config;

import com.liu.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lms
 * @date 2021-05-18 - 19:47
 *
 * 1.编写一个拦截器实现 HandlerInterceptor 接口
 * 2. 拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3. 指定拦截器拦截的规则,[如果是拦截所有，静态资源也会被拦截]
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    // 给拦截器注册中心添加拦截的对象
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")   // 所有的请求都会被拦截，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); ///请求被放行的路径
    }
}
