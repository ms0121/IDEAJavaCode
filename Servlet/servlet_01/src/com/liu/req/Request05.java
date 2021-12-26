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
@WebServlet("/req05")
public class Request05 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("name", "zhangsan");
        req.setAttribute("age", 18);

        // 使用请求转发的方式，让req06中的请求拿到数据信息
        req.getRequestDispatcher("req06").forward(req,resp);

        // 大多数是让数据设置在请求域，让页面进行获取数据信息

    }
}
