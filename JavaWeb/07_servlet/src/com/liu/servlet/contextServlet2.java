package com.liu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-03-31 - 19:13
 */
public class contextServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取servletContext对象
        ServletContext context = getServletContext();
        System.out.println("context = " + context);
        System.out.println(context.getAttribute("key1"));
        context.setAttribute("key1", "value1");
        System.out.println(context.getAttribute("key1"));


    }
}
