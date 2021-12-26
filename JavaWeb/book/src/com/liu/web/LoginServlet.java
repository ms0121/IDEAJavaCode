package com.liu.web;

import com.liu.pojo.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-01 - 17:57
 */
public class LoginServlet extends HttpServlet {

    // 创建UserServiceImpl的对象去操作数据库信息
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(new User(username, password, null));
        if (user == null){
            // 把登录失败的错误信息进行回传提示，并把错误信息和回显的表单项信息保存到request域中
            // 所以需要回显的信息都需要将其保存到request域中
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);

            // 登录失败,无论是否登陆成功都需要设置跳转的页面路径信息，以及请求重传
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }
}



