package com.liu.spring.test;

import com.liu.spring.pojo.Order;
import com.liu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-10 - 15:17
 */
public class TestUser {

    @Test
    public void test() {
        // 1. 加载spring配置文件(特点：在加载配置文件的同时就会进行创建对象)
        // BeanFactory 只会进行加载配置文件，并不会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("./bean.xml");
        // 2. 获取配置文件的对象
        User user = context.getBean("user", User.class);

        user.add();
    }

    @Test
    public void test2() {
        // 加载配置文件（再加载配置文件的同时就会创建对象）
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 通过配置文件创建对象
        User user = context.getBean("user", User.class);
        System.out.println("user = " + user);
    }


    @Test
    public void test3() {
        // 获取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 通过配置文件创建对象并实例化
        Order order = context.getBean("order", Order.class);
        System.out.println("order = " + order);
    }
}






