package com.liu.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author lms
 * @date 2021-09-26 - 20:31
 *  SpringMVC的配置类添加，等价于以前的配置文件：servlet-context.xml
 *
 *     1. SpringMVC配置信息MvcConfig文件添加，作为mvc框架环境，原来是通过xml来进行相关的配置，比如
 *  视图解析器，Json转换器，文件上传解析器等，这里基于注解通过集成WebMvcConfigurerAdapter类并重写
 *  相关方法来进行配置（主要是通过注解 @EnableWebMvc 来启动MVC环境）
 *
 *     2. MvcConfig类定义好之后，那么问题又来了，怎么加载MVCConfig类呢?以前在构建Mvc应用的时候是通过
 *  容器应用时加载web.xml文件实现配置文件的加载，现在的环境web.xml文件不存在，此时基于注解方式构建的
 *  Mvc应用，定义WebInitializer实现WebApplicationInitializer接口（该接口用来配置Servlet3+配置的接口，
 *  主要用于替代web.xml配置），当servlet容器启动Mvc应用时会通过SpringServletContainerInitializer接口
 *  进行加载，从而加载Mvc应用的信息配置，实现该接口的onStartup方法。
 */
@Configuration
//启用mvc的环境
//在@Configuration注解的配置类中添加，用于为该应用添加SpringMVC的功能
@EnableWebMvc
@ComponentScan("com.liu.mvc")
public class MvcConfig {

    /**
     * 这部分等价于以前的配置文件springmvc.xml中的视图解释器
     * 配置视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        // 获取视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 设置前缀
        resolver.setPrefix("/WEB-INF/views/");
        // 设置后缀
        resolver.setSuffix(".jsp");
        // 返回视图解析器对象，并交给Ioc进行管理
        return resolver;
    }

}
