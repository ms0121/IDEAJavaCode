package com.liu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-03-30 - 20:52
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("构造器执行了");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init初始化了");
//        1、可以获取 Servlet 程序的别名 servlet-name 的值
        String servletName = servletConfig.getServletName();
        System.out.println("servletName = " + servletName);
//        2、获取初始化参数 init-param
        String username = servletConfig.getInitParameter("username");
        System.out.println("username = " + username);
        String url = servletConfig.getInitParameter("url");
        System.out.println("url = " + url);
//        3、获取 ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("servletConfig = " + servletConfig);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 专门用来处理请求和返回响应的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet被访问了~~~");
        // 类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            System.out.println("执行了GET请求");
        } else if ("POST".equals(method)) {
            System.out.println("执行了POST请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("程序销毁了");
    }
}
