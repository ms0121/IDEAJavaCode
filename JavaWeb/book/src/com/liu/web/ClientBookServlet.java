package com.liu.web;

import com.liu.pojo.Book;
import com.liu.pojo.Page;
import com.liu.service.BookService;
import com.liu.service.impl.BookServiceImpl;
import com.liu.utils.WebUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-05 - 23:09
 */

public class ClientBookServlet extends BaseServlet {

    // 创建service对象，实现对Dao层的访问
    private BookService bookService = new BookServiceImpl();

    // 处理分页的功能
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("经过了ClientBookServlet前台");
        // 1. 获取请求参数的 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2. 调用BookService.page(pageNo, pageSize)，返回得到Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        // 3、将Page对象保存到request域中
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        // 4、请求转发到/page/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }


    // 根据价格区间进行查询书籍的分页状态信息
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求参数pageNo，pageSize，min，max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        // 2.调用bookService.pageByPrice(pageNo，pageSize，min，max)获取到page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        // 使用线程不安全的StringBuilder，因为属于项目内部
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 判断是否有当前页,如果有将进行拼接，目的实现查询之后的页面跳转
        if (req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        // 设置访问的URL路径给当前的page对象
        page.setUrl(sb.toString());

        // 3、将Page对象保存到request域中
        req.setAttribute("page", page);
        // 4.实现请求转发到/pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}




