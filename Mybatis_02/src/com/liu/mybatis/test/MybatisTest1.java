package com.liu.mybatis.test;

import com.liu.mybatis.bean.Employee;
import com.liu.mybatis.dao.EmployeeMapper;
import com.liu.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest1 {

    /**
     * 1. 根据xml配置文件（全局配置文件）创建一个SQLSessionFactory对象
     * 2. sql映射文件，配置了一些sql，以及sql的封装规则
     * 3. 将sql映射文件注册在全局配置文件中，
     * 4， 写代码：
     * 1. 根据全局配置文件得到SQLSessionFactory
     * 2. 使用SQLSession工厂，获取到SQLSession对象，使用他来执行增删改查的
     * 一个SQLSession就是代表和数据库的一次对话，用完就要关闭
     * 3. 使用sql的唯一标志来告诉Mybatis执行哪个sql，sql都是保存在sql映射文件中
     */
    // 直接返回一个session对象
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(3, "lms", null, null);
            List<Employee> employeeList = mapper.getEmpsByConditionIf(employee);
            System.out.println("employeeList = " + employeeList);
        } finally {
            sqlSession.close();
        }
    }

}
