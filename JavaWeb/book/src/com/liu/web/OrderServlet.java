package com.liu.web;

import com.liu.pojo.Cart;
import com.liu.pojo.User;
import com.liu.service.BookService;
import com.liu.service.OrderService;
import com.liu.service.impl.BookServiceImpl;
import com.liu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-08 - 16:45
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null){
            // 请求转发到登录界面，并结束向下执行
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        String orderId = orderService.createOrder(cart, loginUser.getId());
        // 将生成的订单号orderId保存到request域中
        // req.setAttribute("orderId", orderId);
        // 请求转发到订单界面,为了避免刷新之后重读提交，不推荐使用请求转发，推荐使用重定向
        // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        // 并且重定向不支持使用request域，所以改用session域
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}




