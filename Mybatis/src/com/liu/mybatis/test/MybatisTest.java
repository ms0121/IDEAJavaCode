package com.liu.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.liu.mybatis.bean.Employee;
import com.liu.mybatis.bean.EmployeeExample;
import com.liu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisTest {

    /**
     * 1. 根据xml配置文件（全局配置文件）创建一个SQLSessionFactory对象
     * 2. sql映射文件，配置了一些sql，以及sql的封装规则
     * 3. 将sql映射文件注册在全局配置文件中，
     * 4， 写代码：
     *         1. 根据全局配置文件得到SQLSessionFactory
     *         2. 使用SQLSession工厂，获取到SQLSession对象，使用他来执行增删改查的
     *              一个SQLSession就是代表和数据库的一次对话，用完就要关闭
     *         3. 使用sql的唯一标志来告诉Mybatis执行哪个sql，sql都是保存在sql映射文件中
     */

        @Test
        public void test1() throws IOException {
            // 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取创建的SqlSession对象
            // 使用 SqlSessionFactory 获取 sqlSession 对象。一 个
            // SqlSession 对象代表和数据库的一次会话 。
        // 第一个参数： sql语句的唯一标志符,就是mapper文件中的id
        // 第二个参数就是查询的参数设置

//        SqlSession openSession = sqlSessionFactory.openSession();
//        try {
//            // 唯一标志表示的是告诉程序执行哪个sql语句
//            Employee employee = openSession.selectOne("com.liu.mybatis.EmployeeMapper.selectEmp", 1);
//            System.out.println(employee);
//        } finally {
//            openSession.close();
//        }
    }

    // 直接返回一个session对象
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


    @Test
    public void testMybatis3Simple() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper;
        try {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee = employeeMapper.selectByPrimaryKey(2);
//            System.out.println("employee = " + employee.getEmail());
//            查询所有员工信息
            List<Employee> employees = employeeMapper.selectByExample(null);
            for (Employee employee : employees) {
                System.out.println("employee = " + employee.getId());
            }
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testMybatis3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            1、查询所有员工信息
//            xxxExample就是用来封装复杂的查询条件
//            查询所有的员工信息(只传入null的时候)
//            List<Employee> employees = mapper.selectByExample(null);

//            2、查询员工中名字带有 s 字母的，并且员工的性别是w的
//            封装查询条件的example
            EmployeeExample example = new EmployeeExample();
//            创建一个Criteria，这个Criteria就是用来拼接查询条件的
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andLastNameLike("%s%");
            criteria.andGenderEqualTo("w");
//            criteria拼接的SQL查询语句如下：
    //            select id, last_name, gender, email, d_id from tbl_employee
    //            WHERE ( last_name like ? and gender = ? )
    //            假如现在在2的基础上添加 或者 email里面包含字母 q 的
            EmployeeExample.Criteria criteria1 = example.createCriteria();
            criteria1.andEmailLike("%q%");
//            拼接两个查询条件
//             select id, last_name, gender, email, d_id from tbl_employee
//             WHERE ( last_name like ? and gender = ? ) or( email like ? )
            example.or(criteria1);

            List<Employee> employees = mapper.selectByExample(example);

            for (Employee employee : employees) {
                System.out.println("employee = " + employee.getId());
            }
        } finally {
            sqlSession.close();
        }
    }

    // 使用接口的方式实现
    // 接口式编程的实现（推荐使用）
    /**
     * 1. 接口式编程：
     *      原生：     dao ---->  daoImpl
     *      mybatis:   mapper ---> xxMapper.xml
     * 2. SQLSession代表和数据库的一次会话，用完必须关闭
     * 3. SQLSession和connection一样都是非线程安全的，每次使用都应该去获取新的对象
     * 4. Mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
     *          （将接口和xml合并）
     *          EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
     * 5. 两个重要的配置文件：
     *      1.mybatis的全局配置文件，包含数据库连接池信息，事务管理器信息等，
     *      sql映射文件保存了每一个sql语句的映射信息，将sql抽取出来
     */

    // 使用你想工程生成相应的bean,dao接口，mapper文件
    @Test
    public void testMBG() throws Exception {
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("mbg.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
    }
}

