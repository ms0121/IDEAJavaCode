package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 16:52
 */
@WebServlet("/online")
public class OnlineServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 通过session获取当前在线的人数
        HttpSession session = req.getSession();

        // 退出的人数
        String key = req.getParameter("key");
        if (key != null && "logout".equalsIgnoreCase(key)){
            session.invalidate();
            return;
        }

        // 登录
        Integer onlineNum = (Integer) session.getServletContext().getAttribute("onlineNum");

        // 通过响应流字符流将在线人数输出到页面显示
        // 如果online请求携带有参数，则表示退出的操作，没有携带为登录操作
        resp.getWriter().write("<h3>当前在线的人数为: " + onlineNum + "</h3><br>" +
                "<a href='online?key=logout'>退出</a>");
    }
}
