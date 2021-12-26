package com.liu.web;

import com.google.gson.Gson;
import com.liu.pojo.Book;
import com.liu.pojo.Cart;
import com.liu.pojo.CartItem;
import com.liu.service.BookService;
import com.liu.service.impl.BookServiceImpl;
import com.liu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-08 - 8:35
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();


    /**
     * 修改商品的数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取请求的参数 商品编号，商品的数量
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        // 获取cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            // 修改商品的数量
            cart.updateCount(id, count);
            // 重定向回到原购物车的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            // 清空购物车
            cart.clear();
            // 重定向回到购物车界面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 删除商品项信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到要删除的商品项的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 获取cart购物车的信息
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            // 删除该id对应的商品项
            cart.deleteItem(id);
            // 重定向回到购物车的展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 加入购物车的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("成功加入购物车！");
        // System.out.println("获取的商品id = " + req.getParameter("id"));
        // 1.获取请求的参数，即得到需要添加到购物车的商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 2.调用BookService.queryBookById，获取到book图书对象
        Book book = bookService.queryBookById(id);
        // 3.把图书转为cartItem对象，即商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 4.调用cart.addItem(cartItem)添加商品项
        // 获取Session中的cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        // 最后一个添加的商品信息
        req.getSession().setAttribute("lastName", cartItem.getName());
        System.out.println("cart = " + cart);
        System.out.println(req.getHeader("Referer"));
        // 5.重定向回到商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("成功加入购物车！");
        // System.out.println("获取的商品id = " + req.getParameter("id"));
        // 1.获取请求的参数，即得到需要添加到购物车的商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 2.调用BookService.queryBookById，获取到book图书对象
        Book book = bookService.queryBookById(id);
        // 3.把图书转为cartItem对象，即商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 4.调用cart.addItem(cartItem)添加商品项
        // 获取Session中的cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        // 最后一个添加的商品信息
        req.getSession().setAttribute("lastName", cartItem.getName());
        //        System.out.println("cart = " + cart);
        //        System.out.println(req.getHeader("Referer"));

        // 6.返回购物车的商品数量和最后一个添加的商品名称
        Map<String, Object> resMap = new HashMap<>();

        resMap.put("totalCount", cart.getTotalCount());
        resMap.put("lastName", cartItem.getName());

        // 将需要返回到页面的信息转为json对象
        Gson gson = new Gson();
        String json = gson.toJson(resMap);
        // 使用响应流的方式将数据传回到请求页面
        resp.getWriter().write(json);
    }
}
















