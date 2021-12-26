package com.liu.mybatis.test;

import com.liu.mybatis.bean.Department;
import com.liu.mybatis.bean.Employee;
import com.liu.mybatis.dao.DepartmentMapper;
import com.liu.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
public class MybatisPlusTest {

    // 直接返回一个session对象
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            // 嵌套结果1
            // Department department = mapper.getDeptByIdPlus(1);

            // 分布查询
            Department department = mapper.getDeptByIdStep(1);
            System.out.println("department = " + department);
            for (Employee employee : department.getEmps()) {
                System.out.println("employee = " + employee);
            }
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = mapper.getEmpAndDept(2);
            System.out.println("employee = " + employee.getEmail());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = mapper.getDeptById(1);
            System.out.println("department = " + department);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 在使用之前必须将sql映射文件(EmployeeMapperPlus.xml)添加到全局配置文件(mybatis_config.xml)中
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee emp = mapper.getEmpById(2);
            System.out.println("emp = " + emp);
        } finally {
            sqlSession.close();
        }
    }

}
