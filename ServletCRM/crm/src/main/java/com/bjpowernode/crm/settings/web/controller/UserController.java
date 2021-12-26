package com.bjpowernode.crm.settings.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-12 - 22:07
 */
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("用户进入到了方法之中");
        // 获取得到的是web.xml中<url-pattern>的值（没有前面的斜杠开头），如：settings/user/xx.do
        String path = request.getServletPath();
        if ("settings/user/xx.do".equals(path)){

        }else{

        }
    }
}
