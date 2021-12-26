package com.liu.test;

import com.liu.domain.Student;
import com.liu.utils.MyUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lms
 * @date 2021-05-05 - 9:09
 */
public class StudentTest {

    public static void main(String[] args) throws IOException {
        // 访问mybatis读取student数据信息
        // 1.定义mybatis的主配置文件的名称，从类路径的根开始，（target/clasess）
        String config = "mybatis.xml";
        // 2. 读取这个config配置文件的
        InputStream in = Resources.getResourceAsStream(config);
        // 3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        // 5.[重要]获取SQLSession对象，从SqlSessionFactory中获取sqlSession
        SqlSession sqlSession = factory.openSession();
        // 6. [重要]指定要执行的sql语句的标识，sql映射文件的中的namespace + "." + 标签的id值
        // String sqlId = "com.liu.dao.StudentDao" + "." + "selectStudents";
        String sqlId = "com.liu.dao.StudentDao.selectStudents";
        // 7.执行sql语句，通过sqlId找到要执行的sql语句
        List<Student> list = sqlSession.selectList(sqlId);

        for (Student student : list) {
            System.out.println("student = " + student);
        }

        // 8.关闭sqlSession对象
        sqlSession.close();
    }


    public void test1() {
        SqlSession sqlSession = MyUtils.getSqlSession();
        // 6. [重要]指定要执行的sql语句的标识，sql映射文件的中的namespace + "." + 标签的id值
        // String sqlId = "com.liu.dao.StudentDao" + "." + "selectStudents";
        String sqlId = "com.liu.dao.StudentDao.selectStudents";
        // 7.执行sql语句，通过sqlId找到要执行的sql语句
        List<Student> list = sqlSession.selectList(sqlId);

        for (Student student : list) {
            System.out.println("student = " + student);
        }

        // 8.关闭sqlSession对象
        sqlSession.close();
    }
}
