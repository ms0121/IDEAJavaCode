package com.liu;

import com.liu.dao.StudentDao;
import com.liu.domain.Student;
import com.liu.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-27 - 9:52
 */
public class SpringTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

        // 使用配置文件的方式
        StudentService studentService = (StudentService) context.getBean("studentService");

//        插入学生信息
//        System.out.println("studentDao = " + studentDao);
//        int flag = studentDao.addStudent(new Student("卫俊浩22", 26));
//        // spring和
//        System.out.println("flag = " + flag);

//        查询学生信息
        List<Student> students = studentService.queryStudents();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }
}
