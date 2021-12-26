package com.liu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.liu.mybatis.bean.Employee;
import com.liu.mybatis.dao.EmployeeMapper;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;

public class MybatisTest {

	 // 直接返回一个session对象
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        // 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }	
    
    /*
     * http://dist.springsource.com/release/TOOLS/update/e4.4/
     * 两级缓存：
     * 		一级缓存（本地缓存）：SQLSession级别的缓存，一级缓存是一直开启的
     * 		与数据库同义词会话期间查询到的数据会放在本地缓存中
     * 		以后如果要获取相同的数据，直接从缓存中拿取，没必要再去查询数据库
     * 
     * 		一级缓存失效的情况：没有使用一级缓存的情况，效果就是，还需要再向数据库发出查询信息
     * 			1. SQLSession不同
     * 			2. SQLSession相同，查询条件不同（当前的一级缓存中没有这个数据）
     * 			3. SQLSession相同，两次查询之间执行了增删改查的操作（这次的增删改查对当前数据有影响
     * 			4. SQLSession相同，但是手动的清除了一级缓存（缓存被清空）
     * 
     * 		二级缓存（全局缓存）：基于namespace级别的缓存，一个namespace对应于一个二级缓存
     * 		工作机制：
     * 			1. 一个会话，查询一条数据信息，这个数据信心就会被放在当前会话的一级缓存中
     * 			2. 如果会话关闭，一级缓存中的数据就会被保存到二级缓存中，新的会话查询信息，就可以参照二级缓存机制
     * 			3.SQLSession == EmployeeMapper  == Employee
     * 			不同的namespace查出的数据会放在自己对应的缓存中
     * 		效果：数据会从二级缓存中进行获取
     * 			查出的数据都会被默认先放在一级缓存中
     * 			只有会话提交或者关闭之后，一级缓存中的数据才会转移到二级缓存中
     * 			
     * 	使用：
     * 		1.开启二级缓存配置<cache eviction="FIFO" flushInterval="60000"></cache>
     * 		2. 去Mapper.xml中配置使用
     * 		3. 我们的pojo需要实现序列化接口
     */

    // 实现批量插入的操作
    @Test
    public void testBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 获取批量的SQLSession对象
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        openSession.close();
//        long start = System.currentTimeMillis();
//        try {
//            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//            mapper.addEmp(new Employee("zhansgan", 'w',"8983@qq.om"));
//            System.out.println("插入成功");
//        } finally {
//            openSession.close();
//        }

    }



    // 实现分页的功能
    @Test
    public void testPage() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            // 实现分页的功能：使用pageHeader,参数分别是：起始页，每页的数量
            Page<Object> page = PageHelper.startPage(3, 1);

            // 返回所有员工信息
            List<Employee> empList = mapper.getEmpList();
            // 将获取的数据进行封装
//            PageInfo<Employee> info = new PageInfo<>(empList);

            // 传入要连续显示几页
            // 实现更好的分页逻辑
            PageInfo<Employee> info = new PageInfo<>(empList, 3);

            for (Employee employee : empList) {
                System.out.println("employee = " + employee);
            }

//            System.out.println("当前页码数 = " + page.getPageNum());
//            System.out.println("总记录数 = " + page.getTotal());
//            System.out.println("每页的记录数 = " + page.getPageSize());
//            System.out.println("总页码 = " + page.getPages());

            System.out.println("当前页码数 = " + info.getPageNum());
            System.out.println("总记录数 = " + info.getTotal());
            System.out.println("每页的记录数 = " + info.getPageSize());
            System.out.println("总页码 = " + info.getPages());
            System.out.println("是否是第一页 = " + info.isIsFirstPage());

            System.out.println("========分页逻辑========");
            int[] nums = info.getNavigatepageNums();
            for (int num : nums) {
                System.out.println("num = " + num);
            }

        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void test1() throws IOException {
        // 直接获取一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2.获取SQLSession对象,没有参数表明不会进行自动提交数据信息
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println("sqlSession = " + sqlSession);

        // 获取接口的实现类对象
        try {
            // 会为接口自动的创建一个代理对象，代理对象(就类似是EmployeeDao的实现类)去执行增删改查的方法
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            // 实现类去调用操作数据的方法
            // 查询员工
            Employee employee = mapper.getEmpById(2);
            System.out.println("employee = " + employee);
            Employee employee2 = mapper.getEmpById(2);
            System.out.println(employee2);
            System.out.println(employee==employee2);

        } finally{
        	sqlSession.close();
        }
    }
    
}
