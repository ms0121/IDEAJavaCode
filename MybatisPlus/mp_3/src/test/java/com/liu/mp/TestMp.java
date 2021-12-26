package com.liu.mp;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-05 - 21:19
 *
 * 当前测试的是使用AR中的Model父类中的方法： 增删改查
 */
public class TestMp {

    // 自动生成对应的实体类等
    @Test
    public void testGenerator() {
        // 1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)  // 设置是否支持AR模式
                .setAuthor("lms")  // 作者
                .setOutputDir("D:\\E_DISK\\IDEAJavaCode\\MybatisPlus\\mp_3\\src\\main\\java")  // 生成的路径
                .setFileOverride(true) // 设置每次生成的文件都会覆盖上一次的文件信息
                .setIdType(IdType.AUTO)  // 主键策略
                .setServiceName("%sService")  // 设置生成的service文件的首字母是否为I， 即默认生成为IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        // 2.数据源的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL) // 设置数据的类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("");

        // 3.策略选择
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  // 开启全局大写
                .setDbColumnUnderline(true)  // 指定表名字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据表映射到实体类中的命名策略，
                                                        // 即使用下划线对应驼峰命名的规则
                .setTablePrefix("tbl_")  // 数据表的前缀
                .setInclude("tbl_employee"); // 生成的表

        // 4.包名的策略配置（即将生成的文件放置在哪些包下）
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.liu.mp")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");


        // 5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        // 6.执行操作
        autoGenerator.execute();

    }

}
