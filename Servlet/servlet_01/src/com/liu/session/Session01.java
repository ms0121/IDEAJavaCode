package com.liu.session;

import com.liu.cookie.CreateCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 21:07
 */

@WebServlet("/session01")
public class Session01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        // 如果浏览器中不存在session则会进行创建并返回，否则直接获取
        HttpSession session = req.getSession();
        String sessionId = session.getId();
        System.out.println("sessionId = " + sessionId);

        // session的创建时间
        long creationTime = session.getCreationTime();
        System.out.println("creationTime = " + creationTime);
        // session的最后一次访问时间
        long lastAccessedTime = session.getLastAccessedTime();
        System.out.println("lastAccessedTime = " + lastAccessedTime);
        // 判断当前的session是否是新建的
        System.out.println("session.isNew() = " + session.isNew());

    }
}
