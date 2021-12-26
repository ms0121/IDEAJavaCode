package com.liu.mybatis.test;

import com.liu.mybatis.bean.Employee;
import com.liu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MybatisTest {

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

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 唯一标志表示的是告诉程序执行哪个sql语句
            Employee employee = openSession.selectOne("com.liu.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    // 直接返回一个session对象
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    // 使用接口的方式实现
    // 接口式编程的实现（推荐使用）

    /**
     * 1. 接口式编程：
     * 原生：     dao ---->  daoImpl
     * mybatis:   mapper ---> xxMapper.xml
     * 2. SQLSession代表和数据库的一次会话，用完必须关闭
     * 3. SQLSession和connection一样都是非线程安全的，每次使用都应该去获取新的对象
     * 4. Mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
     * （将接口和xml合并）
     * EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
     * 5. 两个重要的配置文件：
     * 1.mybatis的全局配置文件，包含数据库连接池信息，事务管理器信息等，
     * sql映射文件保存了每一个sql语句的映射信息，将sql抽取出来
     */
    @Test
    public void test2() throws IOException {
        // 直接获取一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口的实现类对象
        // 会为接口自动的创建一个代理对象，代理对象去执行增删改查的方法
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println("mapper.getClass().getClass() = " + mapper.getClass().getClass());
            System.out.println("employee = " + employee);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void test3() throws IOException {
        // 直接获取一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2.获取SQLSession对象,没有参数表明不会进行自动提交数据信息
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口的实现类对象
        try {
            // 会为接口自动的创建一个代理对象，代理对象(就类似是EmployeeDao的实现类)去执行增删改查的方法
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            // 实现类去调用操作数据的方法

            // 查询员工
            Employee employee = mapper.getEmpById(2);
            System.out.println("employee = " + employee);

            // 添加员工
//            mapper.addEmp(new Employee(null, "lisi", 'w',"7832@126.com"));

            // 修改员工
//            mapper.updateEmp(new Employee(1,"wangwu", 'w', "8382@qq.com"));

            // 删除员工
//            mapper.deleteEmpById(1);

            // 根据id和name进行查找员工
//            Employee employee = mapper.getEmpByIdAndName(3, "lms");
//            System.out.println("employee = " + employee);

            // 返回员工列表
//            List<Employee> employees = mapper.queryForEmps("%s%");
//            for (Employee employee : employees) {
//                System.out.println(employee);
//            }

            // 返回员工信息的map集合
//            Map<String, Object> empByIdReMap = mapper.getEmpByIdReMap(2);
//            System.out.println(empByIdReMap);

            // 返回多条记录信息
//            Map<Integer, Employee> empByreturnMap = mapper.getEmpByreturnMap("%s%");
//            for (Map.Entry<Integer, Employee> entry : empByreturnMap.entrySet()) {
//                System.out.println(entry);
//            }

            // 手动提交数据
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
