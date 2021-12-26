package com.liu.jdbc.dao;

import com.liu.jdbc.entity.Book;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-12 - 14:18
 */
public interface BookDao {

    public void addBook(Book book);

    public void deleteBook(int id);

    public void updateBook(Book book);

    public int findCount();

    public Book queryBook(int id);

    public List<Book> queryBookList();

    public void addBatchBook(List<Object[]> bookList);

    public void updateBatchBook(List<Object[]> bookList);

    public void deleteBatchBook(List<Object[]> bookList);
}
