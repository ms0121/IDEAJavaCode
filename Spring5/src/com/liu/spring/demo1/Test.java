package com.liu.spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-10 - 22:06
 */
public class Test {
    public static void main(String[] args) {

        // 1. 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        // 2. 获取加载配置文件创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println("emp = " + emp);
    }
}
