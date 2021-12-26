package com.liu.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author lms
 * @date 2021-09-26 - 20:51
 *
 *     2. MvcConfig类定义好之后，那么问题又来了，怎么加载MVCConfig类呢?以前在构建Mvc应用的时候是通过
 * 容器应用时加载web.xml文件实现配置文件的加载，现在的环境web.xml文件不存在，此时基于注解方式构建的
 * Mvc应用，定义WebInitializer实现WebApplicationInitializer接口（该接口用来配置Servlet3+配置的接口，
 * 主要用于替代web.xml配置），当servlet容器启动Mvc应用时会通过SpringServletContainerInitializer接口
 * 进行加载，从而加载Mvc应用的信息配置，实现该接口的onStartup方法。（容器启动的时候将其注入到容器当中）
 *
 * 注意： 实现WebApplicationInitializer 接口的类都可以在web应用程序启动的时候被加载。
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 基于Java的配置类加载Spring的应用上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 注册mvc配置信息
        context.register(MvcConfig.class);
        // 设置servletContext的上下文信息
        context.setServletContext(servletContext);
        // 配置转发器 DispatcherServlet
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        // 设置映射器路径（表示拦截所有的用户请求）
        servlet.addMapping("/");
        // 启动时即实例化 Bean
        servlet.setLoadOnStartup(1);
    }
}
