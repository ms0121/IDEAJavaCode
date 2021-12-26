package com.liu.test;

import com.liu.pojo.Book;
import com.liu.pojo.Page;
import com.liu.service.BookService;
import com.liu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lms
 * @date 2021-04-04 - 16:26
 */
public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(25, "社会我山哥", "王冰冰",
                new BigDecimal(19999), 1000, 3, null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        Book book = new Book(25, "社会我山鸡哥", "lms",
                new BigDecimal(199), 100, 99, null);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(25);
        System.out.println("book = " + book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book: books){
            System.out.println("book = " + book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(2,4,10,50);
        System.out.println(page);
    }


}