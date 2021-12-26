package com.liu.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 15:35
 */
@WebServlet("/req01")
public class ServletPlus extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求时的完整路径信息(从http开始，到？前结束)
        String url = request.getRequestURL() + "";
        System.out.println("url = " + url);

        // 获取请求时的部分路径信息（从项目的站点名开始，到？前面结束）
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);

        // 获取请求时的参数字符串信息
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);

        // 获取请求的方式（get，post方式）
        String method = request.getMethod();
        System.out.println("method = " + method);

        // 获取当前的协议版本
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);

        // 获取项目的站点名（项目对外访问路径）
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        /**
         * 获取请求的参数,常用
         */
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        String pwd = request.getParameter("pwd");
        System.out.println("pwd = " + pwd);

        /**
         * 获取请求的参数数组，常用语复选框的判断
         */
        String[] hobbies = request.getParameterValues("hobby");
        if (hobbies != null && hobbies.length > 0){
            for (String hobby : hobbies) {
                System.out.println("hobby = " + hobby);
            }
        }
    }
}

















