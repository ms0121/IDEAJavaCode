package com.liu.spring.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-11 - 9:11
 */
public class StuTest {
    public static void main(String[] args) {

        // 加载spring配置文件（在进行加载配置文件的同时会创建相应的对象）
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        // 获取配置文件中的对象
        Stu stu = context.getBean("stu", Stu.class);
        Stu stu1 = context.getBean("stu", Stu.class);
         stu.show();
        // 默认是使用的单实例
//        System.out.println("stu = " + stu);
//        System.out.println("stu1 = " + stu1);

        // 设置多实例对象
    }
}
