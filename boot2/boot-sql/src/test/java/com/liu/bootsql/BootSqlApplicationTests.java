package com.liu.bootsql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest()
class BootSqlApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	@Test
	void contextLoads() throws SQLException {

		//查看默认数据源 class com.zaxxer.hikari.HikariDataSource
		 System.out.println(dataSource.getClass());

		// pom导入Druid，配置文件加入type: com.alibaba.druid.pool.DruidDataSource
		// 数据源就改变了 ：class com.alibaba.druid.pool.DruidDataSource

		//获取数据库连接
		 System.out.println(dataSource.getConnection());
		 System.out.println(dataSource);

	}
}
