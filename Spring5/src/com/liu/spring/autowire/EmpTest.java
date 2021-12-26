package com.liu.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-11 - 11:42
 */
public class EmpTest {
    public static void main(String[] args) {
        // 加载配置文件并创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean9.xml");
        // 获取配置文件创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println("emp = " + emp);
    }
}
