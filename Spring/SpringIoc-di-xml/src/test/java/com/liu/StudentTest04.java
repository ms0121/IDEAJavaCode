package com.liu;

import com.liu.da04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-25 - 15:14
 */
public class StudentTest04 {

    @Test
    public void test04() {
        String config = "da04/applicationContext.xml";
        // 加载配置文件的信息，加载配置文件的同时会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 获取加载配置文件创建的对象
        // Student student = (Student) context.getBean("student");
        Student student = (Student) context.getBean("student");
        System.out.println("student = " + student);
    }

}
