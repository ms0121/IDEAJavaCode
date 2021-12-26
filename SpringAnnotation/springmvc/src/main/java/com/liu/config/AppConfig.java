package com.liu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

import javax.naming.ldap.Control;

/**
 * @author lms
 * @date 2021-05-08 - 15:31
 */
//springmvc只扫描controller注解，并禁用默认的过滤规则
@ComponentScan(value = "com.liu", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurationSupport {

    // 设置视图解析器
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
//        默认所有的页面都从: /WEB-INF/**.jsp查找
//        registry.jsp();
        // 可以进行自定义的方式进行设置
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

//    开启静态资源的访问(把spring无法处理的资源交给tomcat进行处理)
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
}
