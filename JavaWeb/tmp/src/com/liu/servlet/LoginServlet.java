package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lms
 * @date 2021-04-07 - 15:11
 */
public class LoginServlet extends HttpServlet {

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取session中的存放的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 2.删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //  3.获取用户输入的验证码

        String code = req.getParameter("code");
        // 获取用户名
        String username = req.getParameter("username");
        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println(" 保存到数据库：" + username);
            resp.sendRedirect(req.getContextPath() + "/success.jsp");
        } else {
            System.out.println(" 请不要重复提交表单");
        }
    }

    // 模拟用户的提交信息请求，并且可以实现表单的重复提交
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        // 将用户插入到数据库当中
//        System.out.println("username = " + username);
//        // 使用重定向到登录成功的页面
//        resp.sendRedirect(req.getContextPath() + "/success.jsp");

        // 1.获取session中的存放的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 2.删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //  3.获取用户输入的验证码

        String code = req.getParameter("code");
        // 获取用户名
        String username = req.getParameter("username");
        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println(" 保存到数据库：" + username);
            resp.sendRedirect(req.getContextPath() + "/success.jsp");
        } else {
            System.out.println(" 请不要重复提交表单");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }
}















