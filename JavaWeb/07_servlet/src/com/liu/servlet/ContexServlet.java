package com.liu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-03-31 - 11:56
 */
public class ContexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1、获取 web.xml 中配置的上下文参数 context-param
//        2、获取当前的工程路径，格式: /工程路径
//        3、获取工程部署后在服务器硬盘上的绝对路径
//        4、像 Map 一样存取数据

        // 获取web.xml配置文件中的上下文context参数
        ServletContext context = getServletConfig().getServletContext();
        // 通过context获取初始化的参数键值对
        String username = context.getInitParameter("username");
        System.out.println("username = " + username);
        String password = context.getInitParameter("password");
        System.out.println("password = " + password);

        // 获取当前工程路径
        String contextPath = context.getContextPath();
        System.out.println("contextPath = " + contextPath);

        // 获取绝对路径
        // 获取工程部署后的在服务器硬盘上的绝对路径
        /**
         *  /  斜杠被服务器解析地址为http://ip:port/工程名/
         */
        String realPath = context.getRealPath("/");
        System.out.println("realPath = " + realPath);

        String imgPath = context.getRealPath("/img/1.jpg");
        System.out.println("imgPath = " + imgPath);


    }
}
