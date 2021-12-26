package com.liu.jdbc.service;

/**
 * @author lms
 * @date 2021-04-12 - 14:18
 */

import com.liu.jdbc.dao.BookDao;
import com.liu.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.applet.context.NoopExecutionContext;

import java.util.List;

/**
 * 目的： 通过使用JdbcTemplate实现对数据库信息增删改查的操作
 * 1. 使用注入的方式实现在UserService中引入BookdDao
 * 2. 使用注入的方式实现在BookDao中引入JdbcTemplate
 */

@Service
public class BookService {

    @Autowired  // 自动注入dao
    private BookDao bookDao;

    // 添加图书
    public void addBook(Book book){
        bookDao.addBook(book);
    }

    // 删除
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    // 修改
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    // 查询返回单个数值
    public int findCount(){
        return bookDao.findCount();
    }

    // 查询返回单个对象值
    public Book queryBook(int id){
        return bookDao.queryBook(id);
    }

    // 查询返回图书列表
    public List<Book> queryBookList() {
        return bookDao.queryBookList();
    }

    // 批量添加操作
    public void addBatchBook(List<Object[]> bookList){
        bookDao.addBatchBook(bookList);
    }

    // 批量修改
    public void updateBatchBook(List<Object[]> bookList){
        bookDao.updateBatchBook(bookList);
    }

    // 批量删除
    public void deleteBatchBook(List<Object[]> bookList){
        bookDao.deleteBatchBook(bookList);
    }

}











