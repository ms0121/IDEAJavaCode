package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 17:30
 * 处理用户请求
 */
@WebServlet("/login")
    public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("用户登录中.............");
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        // 此时在登录页面，如果登录的用户是admin，则表示登录成功，重定向至登录成功的页面，否则登陆失败，请求转发到登录页面
        if ("admin".equals(name)){
            req.getSession().setAttribute("user", name);
            // 重定向到首页
            resp.sendRedirect("index.jsp");
        }else {
            // 转发到登录页面
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
