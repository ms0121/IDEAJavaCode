package com.liu.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 16:23
 *
 * 请求转发:
 *  1. 从服务器响应客户端的行为
 *  2. 地址栏不会发生改变
 *  3. 从始至终都是同一个请求，所以请求域中的数据课可以共享
 *
 */
@WebServlet("/req03")
public class Request03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置字符编码的问题
        req.setCharacterEncoding("utf-8");

        // post提交的数据会出现乱码的问题
        System.out.println("request03 ------");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("======================");

        // 1. 直接请求转发到一个新的（请求中）,也就是跳转到Request04的方法中
//        req.getRequestDispatcher("req04").forward(req, resp);

        // 2.请求转发到新的jsp页面
//        req.getRequestDispatcher("index.jsp").forward(req, resp);

        // 3.请求转发到html页面
        req.getRequestDispatcher("index.html").forward(req, resp);



    }
}
