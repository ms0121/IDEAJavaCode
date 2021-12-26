package com.liu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.JDBCType;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-12 - 17:39
 */

@RestController
public class SQLController {

    // 直接可以操作数据库表
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据表
    @GetMapping("/select")
    public List getAll(){
        String sql = "select id, username, money from t_account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        String sql = "delete from t_account where id=?";
        jdbcTemplate.update(sql, id);
    }

    // 添加
    @GetMapping("/add")
    public void add() {
        String sql = "insert into t_account(id, username, money)values(?,?,?)";
        jdbcTemplate.update(sql, 3,"平凡的时间", 90);
    }

    // 修改
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id){
        String sql = "update t_account set username=?,money=? where id=" + id;
        Object[] objects = new Object[2];
        objects[0] = "挪威的森林";
        objects[1] = 100;
        jdbcTemplate.update(sql, objects);
        return "ok";
    }


}
