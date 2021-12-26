package com.liu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 20:35
 *
 * cookie的路径问题：
 *  1.当前服务器下任何项目的任意资源都可以获取cookie对象
 *      设置路径为 ' / ',表示在当前服务器下任何项目都可以访问到该cookie对象
 *  2.只有当前项目下的的资源可以获取到cookie对象（默认不设置cookie的path）
 *      默认不设置cookie的路径 或者 设置为当前站点（项目名）
 *  3.指定项目下的资源可获取cookie对象
 *  4.指定目录下的资源可以获取cookie对象
 */
@WebServlet("/cookie04")
public class CookiePath extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 1.当前服务器下任何项目的任意资源都可以获取cookie对象
        Cookie cookie = new Cookie("cookie01", "cookie01");
        // 设置路径为 ' / ',表示在当前服务器下任何项目都可以访问到该cookie对象
        cookie.setPath("/");
        resp.addCookie(cookie);

        // 2.只有当前项目下的的资源可以获取到cookie对象（默认不设置cookie的path）
        // 默认不设置cookie的路径 或者 设置为当前站点（项目名）
        Cookie cookie1 = new Cookie("cookie02", "cookie02");
        // 设置为当前站点 或者不设置
        resp.addCookie(cookie1);

        // 3.指定项目下的资源可获取cookie对象
        Cookie cookie2 = new Cookie("cookie03", "cookie03");
        cookie2.setPath("/servlet_02");
        resp.addCookie(cookie2);

        // 4.指定目录下的资源可以获取cookie对象
        Cookie cookie3 = new Cookie("cookie04", "cookie04");
        cookie3.setPath("/servlet_01/cookie02");
        resp.addCookie(cookie3);

    }
}
