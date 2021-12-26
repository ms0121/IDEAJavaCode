package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lms
 * @date 2021-03-31 - 20:24
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 获取有多个值的函数
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("hobbies = " + Arrays.asList(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        // 解决中文出现的乱码，设置字符集解决post请求的乱码问题
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 获取有多个值的函数
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("hobbies = " + Arrays.asList(hobbies));
    }
}



