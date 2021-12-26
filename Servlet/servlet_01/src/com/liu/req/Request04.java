package com.liu.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 16:24
 */

@WebServlet("/req04")
public class Request04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符编码的问题
        req.setCharacterEncoding("utf-8");

        // post提交的数据会出现乱码的问题
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        System.out.println("request04 ------");
        System.out.println("name = " + name);
        System.out.println("pwd = " + pwd);
    }
}
