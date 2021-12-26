package com.liu.resp;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 17:18
 *  重定向：发起两次请求，所以参数是不共享的。
 *  地址会出现变化，
 */

@WebServlet("/resp03")
public class Response03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp03=========");

        String name = req.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("=====================");
        // 重定向到Response04中
        resp.sendRedirect("resp04");
    }
}
