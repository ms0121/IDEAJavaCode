package com.liu.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lms
 * @date 2021-11-05 - 11:37
 */
@Configuration
public class DruidConfig {
    //绑定yaml中的配置，
    //这样yaml中关于Druid的配置就能生效了
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean("dataSource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    @Bean("connection")
    public Connection connection(@Qualifier("dataSource") DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
