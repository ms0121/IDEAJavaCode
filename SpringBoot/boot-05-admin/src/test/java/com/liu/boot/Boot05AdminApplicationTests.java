package com.liu.boot;

import com.alibaba.druid.pool.DruidDataSource;
import com.liu.boot.bean.User;
import com.liu.boot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Boot05AdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DruidDataSource dataSource;

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        String sql = "select count(*) from user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("integer = " + integer);
        System.out.println("dataSource = " + dataSource.getClass());
    }


    @Test
    void mapperTest(){
        User user = userMapper.selectById(2);
        System.out.println("user = " + user);
    }

}
