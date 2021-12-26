package com.liu.web;

import com.liu.pojo.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author lms
 * @date 2021-04-01 - 16:35
 */
public class RegisterServlet extends HttpServlet {
    // 用于调用dao层进行操作数据库
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 通过session获取到验证码信息
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        // 获取注册页面的属性值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        // 在servlet页面进行注册
        // 首先检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            // 在通过UserService层来判断数据库中是否存在该信息
            if (userService.existUsername(username)) {
                // 注册失败，把回显的信息保存到request域中
                req.setAttribute("msg", "用户名已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                System.out.println("该用户 [" + username + "] 信息已经存在!");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 直接进行注册用户的信息
                userService.registerUser(new User(username, password, email));
                // 跳转到注册成功的页面，第一个路径信息指的是跳转到的页面路径信息，从而实现请求的转发
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            // 注册失败，把回显的信息保存到request域中
            req.setAttribute("msg", "验证码错误!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            // 验证码不正确，直接返回注册页面
            System.out.println("验证码 [" + code + "] 错误，请重新注册");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}









