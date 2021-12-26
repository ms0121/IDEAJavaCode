package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-03-31 - 21:05
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查看请求的参数（办事的材料），必看
        String username = request.getParameter("username");
        // 在柜台2进行查看数据信息
        System.out.println("username = " + username);
        // 查看柜台1是否有章
        Object key1 = request.getAttribute("key1");
        System.out.println(" 柜台 1  是否有章：" + key1);
        // 处理自己的业务
        System.out.println("Servlet2  处理自己的业务 ");
    }
}
