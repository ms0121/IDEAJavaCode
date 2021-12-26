package com.liu.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author lms
 * @date 2021-05-08 - 11:36
 * AOP:事务配置
 * 1.导入相关的依赖
 *      数据源，数据库驱动，spring-jdbc模块
 * 2.配置数据源JDBCTemplate（spring提供的简化数据操作的工具）操作数据
 * 3.给方法添加标注@Transactional, 表示当前的方法是一个事务方法
 * 4. @EnableTransactionManagement 表示配置类：开启基于注解的事务管理功能
 *          @Enable 表示开启
 * 5、一定要在配置类中配置事务管理器来控制事务（）；
 *
 */
// 扫描组件包，将service，dao加入到容器中
@EnableTransactionManagement
@ComponentScan("com.liu.tx")
@Configuration  //配置类
public class TxConfig {

    // 数据源
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    // jdbcTemplate用于操作数据库
    @Bean
    public JdbcTemplate jdbcTemplate(){
        // spring对@Configuration类会进行特殊的处理，给容器中加组件的方法，多次调用都只是
        // 从容器中找组件
        return new JdbcTemplate(dataSource());
    }

    // 注册事务管理器在ioc容器中,用于管理事务
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
            return new DataSourceTransactionManager(dataSource());
    }

}
