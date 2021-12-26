package com.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lms
 * @date 2021-11-04 - 21:29
 */
@RestController
public class DataController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("data")
    public String data() throws SQLException {
        //查看默认数据源 class com.zaxxer.hikari.HikariDataSource
        // System.out.println(dataSource.getClass());

        // pom导入Druid，配置文件加入type: com.alibaba.druid.pool.DruidDataSource
        // 数据源就改变了 ：class com.alibaba.druid.pool.DruidDataSource

        //获取数据库连接
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource);

        return "处理完毕!";
    }

}
