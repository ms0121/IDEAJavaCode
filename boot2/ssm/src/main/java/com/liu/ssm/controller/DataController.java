package com.liu.ssm.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lms
 * @date 2021-11-04 - 22:39
 */
@RestController
public class DataController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Connection connection;

    @GetMapping("data")
    public String data() throws SQLException {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        // Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        connection.close();

        return "处理完毕!";
    }

}
