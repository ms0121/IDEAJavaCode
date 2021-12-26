package com.liu.service;

import com.liu.pojo.Book;
import com.liu.pojo.Page;

import java.util.List;

/**
 * BookService的接口类
 * @author lms
 * @date 2021-04-04 - 16:17
 */
public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    Page<Book> page(int pageNo, int pageSize);
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
