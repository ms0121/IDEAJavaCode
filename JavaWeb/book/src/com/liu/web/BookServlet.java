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
import java.util.List;

/**
 * @author lms
 * @date 2021-04-04 - 16:48
 */
public class BookServlet extends BaseServlet {

    // 创建service对象，实现对Dao层的访问
    private BookService bookService = new BookServiceImpl();


    // 处理分页的功能
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数的 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2. 调用BookService.page(pageNo, pageSize)，返回得到Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        // 3、将Page对象保存到request域中
        req.setAttribute("page", page);
        // 4、请求转发到/page/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    // 增加
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo = pageNo + 1;
        // 1.获取请求的参数 == 封装成为bean对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        // 2.调用BookService.addBook()方法将图书添加到数据库中
        bookService.addBook(book);
        // 3. 添加成功之后跳转到图书列表的页面: /manager/bookServlet?action=list
        // 请求转发是一次请求, 会出现bag(一刷新就会将数据不断的进行加入到数据库中)
        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);

        // 为了解决请求转发出现的bag，可以使用重定向, 重定向的斜杆 / 代表的是到端口号，所以需要手动获取工程名
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    // 删除
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数id，图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 2. 调用bookService.deleteBookById()，删除图书
        bookService.deleteBookById(id);
        // 3. 删除完毕使用重定向回到列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    // 对图书进行修改并进行提交
    // 根据book_edit页面提交的修改信息，传到servlet中去，进而调用bookServlet.updateBook()修改数据库中的图书信息
    // 然后通过 servlet 给book_manager.jsp回传数据信息并进行显示
    // 给请求返回响应数据
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        // 2、调用 BookService.updateBook( book );修改图书
        bookService.updateBook(book);
        // 3、重定向回图书列表管理页面
        // 地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    // 获取书籍
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 2.调用BookService.queryBookById(id)，Book得到修改的图书信息
        Book book = bookService.queryBookById(id);
        // 3.把图书保存到Request域中
        req.setAttribute("book", book);
        // 4.请求转发到/pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    // 列表
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过BookService查询到所有的图书信息
        List<Book> books = bookService.queryBooks();
        // 2. 把全部的图书信息保存到request域中
        req.setAttribute("books", books);
        // 3. 请求转发到/pages/manager/book_manager.jsp页面当中
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}









