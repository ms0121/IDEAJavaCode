package com.liu.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-05-19 - 8:17
 * 配置数据库连接池
 */
//@Deprecated  // 表示当前的这个类是过期的
@Configuration
public class DruDataSource {

    // 使用配置文件中开头是spring.datasource的进行配置druid的属性
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
