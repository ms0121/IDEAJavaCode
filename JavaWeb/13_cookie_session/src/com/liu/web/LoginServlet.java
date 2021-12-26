package com.liu.web;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-06 - 21:00
 */
public class LoginServlet extends HttpServlet {

    protected void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(req.getParameter("username"));
        String password = req.getParameter(req.getParameter("password"));

        if ("lms168".equals(username) && "123456".equals(password)){
            Cookie cookie = new Cookie("username", "username");
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
            System.out.println("登录成功!");
        }else {
            System.out.println("登陆失败!");
        }
    }
}
