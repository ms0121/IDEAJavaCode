package com.liu.resp;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lms
 * @date 2021-09-24 - 17:18
 *
 * response响应有两种输出流
 *
 *  1.getWriter  字符串输出流（只能输出字符串）
 *  2.getOutputStream  字节流，可以输出一切数据
 *
 * 注意：这两种流不能同时使用，否则将会抛出错误
 *
 */

@WebServlet("/resp02")
public class Response02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//         设置服务端和服务端的编码格式(适用于字符流的响应数据信息)
//        resp.setContentType("text/html; charset=UTF-8");
//        // 获取字符流
//        PrintWriter writer = resp.getWriter();
//        // 返回响应字符流给客户端
//        writer.write("你好吗!");



//       适用于字节流的编码方式

//        获取字节流
        ServletOutputStream outputStream = resp.getOutputStream();
//        将要发送的消息转为字节的形式进行发送
        outputStream.write("你很好!".getBytes());
    }
}
