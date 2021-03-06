package com.liu;

import com.liu.config.AppConfig;
import com.liu.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author lms
 * @date 2021-05-08 - 15:22
 * web容器启动的时候创建对象，调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //    获取跟容器的配置类（spring的配置文件） 父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 获取web容器的配置类（类似springmvc的配置文件） 子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // 获取DispatcherServlet的映射信息
    /**
     *  / : 拦截所有的请求，包括静态资源(xx.js, xx.png),但是不包括 *.jsp
     *  /*:拦截所有的请求，包括静态资源(xx.js, xx.png, *.jsp)
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
