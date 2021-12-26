package com.liu.test;

import com.liu.dao.BookDao;
import com.liu.dao.impl.BookDaoImpl;
import com.liu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-04 - 15:29
 */
public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        int flag = bookDao.addBook(new Book(null, "你好骚啊", "东方不败", new
                BigDecimal(99), 1000, 20, null));
        System.out.println("flag = " + flag);
    }

    @Test
    public void deleteBookById() {
        int flag = bookDao.deleteBookById(10);
        System.out.println("flag = " + flag);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(29, " 大家都可以这么帅！", " 国哥", new
                BigDecimal(9999), 1100000, 0, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(30);
        System.out.println("book = " + book);
    }

    @Test
    public void quryBooks() {
        List<Book> books = bookDao.quryBooks();
        for (Book book: books){
            System.out.println("book = " + book);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        Integer integer = bookDao.queryForPageTotalCount();
        System.out.println("integer = " + integer);
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(8, 4);
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }


    @Test
    public void queryForPageTotalCountByPrice(){
        Integer integer = bookDao.queryForPageTotalCountByPrice(10,50);
        System.out.println("integer = " + integer);
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(2, 4, 10, 50);
        for (Book book : books) {
            System.out.println("book = " + book);
        }
    }

}