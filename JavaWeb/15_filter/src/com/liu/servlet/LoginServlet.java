package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-09 - 9:53
 */
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)){
            // 将username的信息保存到session域中
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功!");
        }else {
            // 登录失败直接跳转到登录界面
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }

    }
}
