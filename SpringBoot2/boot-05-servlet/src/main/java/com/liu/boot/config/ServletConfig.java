package com.liu.boot.config;

import com.liu.boot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * @author lms
 * @date 2021-05-21 - 16:15
 */
@Configuration
public class ServletConfig {

    // 直接将该组件注入到容器中,并设置访问的路径
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletServletRegistrationBean =
                new ServletRegistrationBean(new MyServlet(), "/servlet");
        return servletServletRegistrationBean;
    }

}
