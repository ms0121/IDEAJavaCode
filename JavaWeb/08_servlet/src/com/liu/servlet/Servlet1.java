package com.liu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-03-31 - 21:06
 */
public class Servlet1 extends HttpServlet {
    // 实现请求的转发，实际就是servlet作为中的审查部门，鉴定完成之后，再交给下一个servlet部门进行核验，执行任务，并返回结果
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String username = request.getParameter("username");
        // 在servlet1中进行审查元素
        System.out.println("username = " + username);
        // 给材料 盖一个章，并传递到 Servlet2（柜台 2）去查看
        request.setAttribute("key1", "柜台1的章");

        // 问路：Servlet2（柜台 2）怎么走
        /**
         * 请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ , 映射到 IDEA 代码的 web 目录，即获取地址
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        // 将数据传递到requesDispatcher里面去
        requestDispatcher.forward(request, response);
    }
}
