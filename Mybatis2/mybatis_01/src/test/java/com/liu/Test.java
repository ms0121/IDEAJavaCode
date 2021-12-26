package com.liu;

import com.liu.dao.StudentDao;
import com.liu.domain.Student;
import com.liu.utils.MyUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-05-05 - 9:57
 */
public class Test {

    @org.junit.Test
    public void test7() {
        SqlSession sqlSession = MyUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(13);
        List<Student> students = studentDao.studentForeach(list);
        for (Student student1 : students) {
            System.out.println("student1 = " + student1);
        }
    }


    @org.junit.Test
    public void test6() {
        SqlSession sqlSession = MyUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("山鸡");
        student.setAge(27);
        List<Student> students = studentDao.selectStudentByWhere(student);
        for (Student student1 : students) {
            System.out.println("student1 = " + student1);
        }
    }


    @org.junit.Test
    public void test5() {
        SqlSession sqlSession = MyUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("");
        student.setAge(19);
        List<Student> students = studentDao.selectStudentByIf(student);
        for (Student student1 : students) {
            System.out.println("student1 = " + student1);
        }
    }

    @org.junit.Test
    public void test4() {
        SqlSession sqlSession = MyUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        int count = studentDao.studentCount();
        System.out.println("count = " + count);
    }



    @org.junit.Test
    public void tets3(){
        SqlSession sqlSession = MyUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        // 实现类对象调用接口中的方法，就是执行sql映射文件中的id值的那个sql语句
        List<Student> students = studentDao.selectMutilParam("李四",20);
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }



    // 知己使用当前的接口名称，
    // 使用sqlSession.getMapper(接口名.class) 获取接口的实现类对象(动态代理的方式)
    @org.junit.Test
    public void test2(){
        SqlSession sqlSession = MyUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        // com.sun.proxy.$Proxy2:jdk的动态代理对象
        System.out.println("studentDao = " + studentDao.getClass().getName());

        // 实现类对象调用接口中的方法，就是执行sql映射文件中的id值的那个sql语句
        List<Student> students = studentDao.selectStudents();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }


    @org.junit.Test
    public void name() throws IOException {
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


        String sqlId = "com.liu.dao.StudentDao.insertStudent";
        // 7.执行sql语句，通过sqlId找到要执行的sql语句
        Student student = new Student();
        student.setId(20);
        student.setName("赞多");
        student.setAge(20);
        int flag = sqlSession.insert(sqlId, student);
        // mybatis默认不自动提交事务，需要手动进行提交事务信息（update，insert，delete）
        sqlSession.commit();
        System.out.println("flag = " + flag);
        // 8.关闭sqlSession对象
        sqlSession.close();
    }


    public static void main(String[] args) {
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
