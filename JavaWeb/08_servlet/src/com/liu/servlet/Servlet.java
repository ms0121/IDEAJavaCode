package com.liu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-03-31 - 20:05
 */
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        a)HttpServletRequest  类有什么作用。
        //        每次只要有请求进入 Tomcat 服务器，Tomcat 服务器就会把请求过来的 HTTP 协议信息解析好封装到 Request 对象中。
        //        然后传递到 service 方法（doGet 和 doPost）中给我们使用。我们可以通过 HttpServletRequest 对象，获取到所有请求的
        //        信息。
        //        i. getRequestURI() 获取请求的资源路径
        System.out.println("资源的路径： " + req.getRequestURI());
        //        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("资源的绝对路径: " + req.getRequestURL());
        //        iii. getRemoteHost() 获取客户端的 ip 地址
        System.out.println(req.getRemoteHost());
        //        iv. getHeader() 获取请求头
        System.out.println(req.getHeaders("User-Agent"));
        // vii. getMethod() 获取请求的方式 GET 或 POST
        System.out.println(req.getMethod());


    }
}
