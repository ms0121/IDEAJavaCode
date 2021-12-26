package com.liu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author lms
 * @date 2021-05-08 - 11:45
 */

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "INSERT INTO tbl_user(name, age)VALUES(?, ?)";
        String name = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, name, 18);
    }
}
