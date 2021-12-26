package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lms
 * @date 2021-03-31 - 22:16
 */
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置服务器的编码方式,该种方式不推荐
        // resp.setCharacterEncoding("utf-8");

        // 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        // 推荐使用该方式
        resp.setContentType("text/html; charset=UTF-8");

        // 往客户端回传数据信息
        PrintWriter writer = resp.getWriter();
        writer.write("lms是一个程序员!");
    }
}
