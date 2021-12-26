package com.liu.cookie;

import com.liu.resp.Response01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.CoderMalfunctionError;

/**
 * @author lms
 * @date 2021-09-24 - 20:19
 * 设置cookie的过期时间
 *  ①默认值
 *      默认值是-1，表示只在当前浏览器中存活，关闭浏览器就会即可删除
 *  ②正整数
 *      表示指定当前cookie的存活时间，单位是秒
 *  ③ 零
 *      表示立刻删除
 */
@WebServlet("/cookie03")
public class ExpiredCookie extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 默认值（关闭浏览器就删除）
        Cookie cookie = new Cookie("name", "zhangsan");
        resp.addCookie(cookie);

        // 正整数
        Cookie cookie1 = new Cookie("name", "lisi");
        // 10秒后过期
        cookie.setMaxAge(10);
        resp.addCookie(cookie1);

        // 0
        Cookie cookie2 = new Cookie("name", "wangwu");
        // 立刻删除
        cookie2.setMaxAge(0);
        resp.addCookie(cookie2);
    }
}
