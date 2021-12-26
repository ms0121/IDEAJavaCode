package com.liu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-06 - 22:59
 */
public class SessionServlet extends BaseServlet {

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("设置session3秒之后销毁");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 设置session马上超时
        session.invalidate();
        resp.getWriter().write("设置session马上被销毁!");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认存活时长: "  + maxInactiveInterval);
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经往Session中保存了数据信息");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("获取Session中的值: " + attribute);
    }



    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建和获取Session对象
        HttpSession session = req.getSession();
        // 判读当前的session对象是否是新创建出来的
        boolean isNew = session.isNew();
        // 获取session唯一的id值
        String id = session.getId();
        resp.getWriter().write("得到的Session，它的Id是: " + id + "<br/>");
        resp.getWriter().write("得到的session是否是新创建的: " + isNew + "<br/>");
    }
}



