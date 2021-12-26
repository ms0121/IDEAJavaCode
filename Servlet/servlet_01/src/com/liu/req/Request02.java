package com.liu.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 15:58
 * 解决请求传递过来的参数中出现的乱码问题现象
 * 出现乱码的原因：由于在解析的过程中默认使用的编码方式是ISO-8859-1（此编码的方式不支持中文的格式）
 *              所以会出现中文的解析错误
 *
 * get请求，tomcat8及以上的版本，get请求不会出现乱码，但是8以下的版本会出现乱码
 *
 * post请求（使用表单进行提交数据），无论使用的tomcat是什么版本，都会出现中文乱码的问题，
 *
 */
@WebServlet("/req02")
public class Request02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符编码的问题
        req.setCharacterEncoding("utf-8");

        // post提交的数据会出现乱码的问题
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("name = " + name);
        System.out.println("pwd = " + pwd);
    }
}
