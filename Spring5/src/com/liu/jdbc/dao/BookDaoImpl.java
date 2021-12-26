package com.liu.jdbc.dao;

import com.liu.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-12 - 14:18
 */
@Repository
public class BookDaoImpl implements BookDao{

    // 自动注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBook(Book book) {
        String sql = "insert into t_book values(?, ?, ?)";
        Object[] args = {book.getUserId(), book.getUserName(), book.getuStatus()};
        int flag = jdbcTemplate.update(sql, args);
        System.out.println("flag = " + flag);
    }

    @Override
    public void deleteBook(int id) {
        String sql = "delete from t_book where user_id = ?";
        int flag = jdbcTemplate.update(sql, id);
        System.out.println("flag = " + flag);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username=?, ustatus= ? where user_id = ?";
        Object[] args = {book.getUserName(), book.getuStatus(), book.getUserId()};
        int flag = jdbcTemplate.update(sql, args);
        System.out.println("flag = " + flag);
    }

    @Override
    public int findCount() {
        String sql = "select count(*) from t_book";
        // queryForObject(sql, 返回值类型.class)
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book queryBook(int id) {
        String sql = "select * from t_book where user_id=?";
        // 第二个参数表示的是 需要返回的bean对象类型
        // 第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面实现类完成数据封装
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> queryBookList() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void addBatchBook(List<Object[]> bookList) {
        String sql = "insert into t_book values(?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, bookList);
    }

    @Override
    public void updateBatchBook(List<Object[]> bookList) {
        String sql =  "update t_book set username=?, ustatus=? where user_id=?";
        jdbcTemplate.batchUpdate(sql, bookList);
    }

    @Override
    public void deleteBatchBook(List<Object[]> bookList) {
        String sql =  "delete from t_book where user_id = ?";
        jdbcTemplate.batchUpdate(sql, bookList);
    }
}







