package com.liu.context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 21:56
 * ServletContext的四种方式：
 *  1.request
 *  2.session
 *  3.getServletConfig
 *  4.getServletContext
 *
 *
 *  常用的方法：
 *      1. 获取当前服务器的版本信息
 *      2. 获取项目的真实路径信息
 */

@WebServlet("/context01")
public class ServletContext01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request的方式获取 ServletContext
        ServletContext servletContext = request.getServletContext();

        // session的方式获取
        ServletContext servletContext1 = request.getSession().getServletContext();

        // getServletConfig的方式获取
        ServletContext servletContext2 = getServletConfig().getServletContext();

        // getServletContext的方式获取
        ServletContext servletContext3 = getServletContext();


        // 1. 获取当前服务器的版本信息
        String serverInfo = servletContext.getServerInfo();
        System.out.println("serverInfo = " + serverInfo);

        // 2. 获取项目的真实路径信息(/表示获取根路径)
        String realPath = servletContext.getRealPath("/");
        System.out.println("realPath = " + realPath);
    }

}
