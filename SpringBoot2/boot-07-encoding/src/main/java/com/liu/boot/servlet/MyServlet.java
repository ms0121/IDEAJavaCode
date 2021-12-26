package com.liu.boot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-22 - 10:50
 *
 * 不配置字符编码器会出现字符的乱码现象
 * 方式一：使用FilterRegistrationBean进行自己配置的方式，（不推荐）
 * 方式二：直接使用主配置文件中的设置方式，就不需要再使用  EncodingConfig这个类的支持了(推荐使用)
 *
 */
@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 给浏览器响应数据信息
        resp.getWriter().write("今天又是努力的一天！， hello world！");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
