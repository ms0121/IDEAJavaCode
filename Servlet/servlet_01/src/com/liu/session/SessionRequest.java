package com.liu.session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 21:20
 * 比较session和request的区别：
 *  session：一次会话，只要不删除 数据，都会存在(如果以后想多次)
 *  request：request中的数据只在一次请求
 *
 *
 */
@WebServlet("/session02")
public class SessionRequest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // cookie的方式
        HttpSession session = req.getSession();
        // 设置域对象
        session.setAttribute("sname", "session");
        session.setAttribute("spwd", "123");
        // 移除域对象
        session.removeAttribute("spwd");

        // request的方式
        req.setAttribute("rname", "request");

        // 执行请求转发的操作，那么session和request都是可以被获取的
//        req.getRequestDispatcher("sr.jsp").forward(req, resp);

        // 执行重定向的操作，那么request的域对象将会失效，session的则可以正常获取
        resp.sendRedirect("sr.jsp");

    }
}
