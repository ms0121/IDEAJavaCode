package com.liu;

import com.liu.ba03.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-25 - 18:55
 */

public class StudentTest03 {

    @Test
    public void test() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) context.getBean("myStudent");
        System.out.println("myStudent = " + myStudent);
    }
}
