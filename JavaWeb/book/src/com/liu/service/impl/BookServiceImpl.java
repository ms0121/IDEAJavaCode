package com.liu.service.impl;

import com.liu.dao.BookDao;
import com.liu.dao.impl.BookDaoImpl;
import com.liu.pojo.Book;
import com.liu.pojo.Page;
import com.liu.service.BookService;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-04 - 16:20
 */
public class BookServiceImpl implements BookService {

    // 创建一个BookDaoImpl实例去操作数据的增删改查
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.quryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        // 创建当前的对象
        Page<Book> page = new Page<>();
        // 设置page对象的各个属性
        // 设置当前的每页的显示数量
        page.setPageSize(pageSize);
        // 通过dao层获取总的记录数量
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        // 设置总的记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        // 设置页码数
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 求当前页的数据
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        // 设置当前页面数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        // 创建当前的对象
        Page<Book> page = new Page<>();
        // 设置page对象的各个属性
        // 设置当前的每页的显示数量
        page.setPageSize(pageSize);
        // 通过dao层获取总的记录数量
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        // 设置总的记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        // 设置页码数
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 求当前页的数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min, max);
        // 设置当前页面数据
        page.setItems(items);
        return page;
    }
}
