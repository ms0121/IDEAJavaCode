package com.liu.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 16:58
 * request的作用域：
 *  通过该对象可以在一个请求中传递数据信息，作用的范围：只在一次请求中有用，即服务器跳转有用（也就是请求转发）
 *
 *  request域对象的数据在一次请求中有效，则经过请求转发，request域中的数据依然存在，则在请求转发的过程中
 *  可以通过request来传输共享数据。
 *
 *
 */
@WebServlet("/req06")
public class Request06 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getAttribute("name");
        Integer age = (Integer) req.getAttribute("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}
