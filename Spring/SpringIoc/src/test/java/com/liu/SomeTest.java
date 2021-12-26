package com.liu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author lms
 * @date 2021-04-25 - 11:03
 */


public class SomeTest {

    @Test
    public void test3() {
        String config = "da01/applicationContext.xml";
        // 加载配置文件的信息，加载配置文件的同时会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 获取加载配置文件创建的对象
        Student student = context.getBean("student");
        System.out.println("student = " + student);
    }

}
