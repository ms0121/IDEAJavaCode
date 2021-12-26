package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 15:08
 */
//表示  /ser01  的请求将会由当前的这个类进行处理请求服务
//@WebServlet("/ser01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ser01正在被处理请求信息。。。。。。。。。。");
    }
}
