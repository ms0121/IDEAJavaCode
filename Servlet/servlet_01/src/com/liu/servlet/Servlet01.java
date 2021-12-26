package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 14:34
 * 实现的步骤：
 *  1.创建类并且继承HttpServlet
 *  2.重写service方法
 *  3.设置注解，并且标明需要访问的路径
 */
//路径中的斜杠不能丢弃
@WebServlet("/ser01")
public class Servlet01 extends HttpServlet {

    /**
     * service方法封装了doGet方法和doPost这两个方法，所以直接使用service方法更加的方便
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==========servlet==========");
        // 输出信息到浏览器，所以使用的是响应流
        resp.getWriter().write("==========servlet==========");
    }
}
