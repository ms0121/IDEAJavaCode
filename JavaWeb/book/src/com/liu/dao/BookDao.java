package com.liu.dao;

import com.liu.pojo.Book;

import java.util.List;

/**
 * @author lmss
 * @date 2021-04-04 - 15:10
 */
public interface BookDao {
    // 添加书籍
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> quryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
