package com.liu.web;

import com.liu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lms
 * @date 2021-04-06 - 17:38
 */
public class CookieServlet extends BaseServlet {


    // 设置cookie的路径信息，可以有效的过滤掉不需要的信息
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // 获取工程路径信息
        cookie.setPath(req.getContextPath() + "/abc");
        // 提示客户端保存信息
        resp.addCookie(cookie);
        resp.getWriter().write("设置了testPath路径信息!");

    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60); // 设置 Cookie 一小时之后被删除。无效
        resp.addCookie(cookie);
        resp.getWriter().write(" 已经创建了一个存活一小时的 Cookie");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null){
            // 设置存活时间为0
            cookie.setMaxAge(0);
            // 通知客户端保存数据
            resp.addCookie(cookie);

        }
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("default", "default");
        // 设置存活时间
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  修改cookie值的方法：
        //    方案一：
        //    1、先创建一个要修改的同名（指的就是 key）的 Cookie 对象
        //    2、在构造器，同时赋于新的 Cookie 值。
        // Cookie cookie = new Cookie("key2", "newValue2");
        //    3、调用 response.addCookie( Cookie );
        // 通知客户端保存修改信息
        //  resp.addCookie(cookie);

        //        方案二：
        //        1、先查找到需要修改的 Cookie 对象
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null){
            //        2、调用 setValue()方法赋于新的 Cookie 值。
            cookie.setValue("newValue1");
            //        3、调用 response.addCookie()通知客户端保存修改
            resp.addCookie(cookie);
        }

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("cookie = " + cookie.getName() + ": " + cookie.getValue() + "<br>");
        }

        // 查找指定键的cookie对象
        Cookie iWanCookie = CookieUtils.findCookie("key1", cookies);
        System.out.println("iWanCookie = " + iWanCookie);

    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        Cookie cookie1 = new Cookie("key2", "value2");
        // 服务端将cookie返回到用户端,通知客服端保存cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie创建成功!");
    }
}
