package com.liu.jdbc.test;

import com.liu.jdbc.dao.BookDao;
import com.liu.jdbc.entity.Book;
import com.liu.jdbc.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lms
 * @date 2021-04-12 - 15:02
 */

@RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架
@ContextConfiguration("classpath:jdbcBean1.xml") // 加载配置文件
public class BookDaoImplTest {

//    // 加载配置文件（加载的同时会创建对象）
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcBean1.xml");
//    // 获取加载配置文件创建的对象
//    BookService bookService = context.getBean("bookService", BookService.class);

    @Autowired  // 直接使用注解的方式代替上述的两行代码
    private BookService bookService;

    @Test
    public void addBook() {
        Book book = new Book();
        book.setUserId(9);
        book.setUserName("Spring从入门到精通");
        book.setuStatus("c");
        bookService.addBook(book);
    }


    @Test
    public void deleteBook() {
        bookService.deleteBook(2);
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setUserId(2);
        book.setUserName("王冰冰");
        book.setuStatus("d");
        bookService.updateBook(book);
    }

    @Test
    public void findCount() {
        int count = bookService.findCount();
        System.out.println("count = " + count);
    }

    @Test
    public void queryBook() {
        Book book = bookService.queryBook(3);
        System.out.println("book = " + book);
    }

    @Test
    public void queryBookList(){
        List<Book> bookList = bookService.queryBookList();
        for (Book book : bookList) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void addBatchBook() {
        // 批量添加测试
        List<Object[]> batchArgs =  new ArrayList<>();
        Object[] o1 = { 4, "java", "a"};
        Object[] o2 = { 5, "c++", "b"};
        Object[] o3 = { 6, "MySQL", "c"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        //调用批量添加
        bookService.addBatchBook(batchArgs);
    }

    @Test
    public void updateBatchBook() {
        // 批量修改
        List<Object[]> batchArgs =  new ArrayList<>();
        Object[] o1 = { "java0909", "a3", 3};
        Object[] o2 = { "c++1010", "b4", 4};
        Object[] o3 = { "MySQL1111", "c5", 5};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        //调用方法实现批量修改
        bookService.updateBatchBook(batchArgs);
    }

    @Test
    public void deleteBatchBook(){
        // 批量删除
        List<Object[]> batchArgs =  new ArrayList<>();
        Object[] o1 = {5};
        Object[] o2 = {4};
        batchArgs.add(o1);
        batchArgs.add(o2);
        //调用方法实现批量删除
        bookService.deleteBatchBook(batchArgs);
    }

}

