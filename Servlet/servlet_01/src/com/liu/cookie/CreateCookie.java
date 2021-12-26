package com.liu.cookie;

import com.liu.resp.Response01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 20:07
 */
@WebServlet("/cookie01")
public class CreateCookie extends HttpServlet {

    /**
     * cookie的创建并将其设置在客户端（浏览器）上
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie
        Cookie cookie = new Cookie("name", "admin");
        // 将cookie设置在浏览器上
        resp.addCookie(cookie);
    }
}
