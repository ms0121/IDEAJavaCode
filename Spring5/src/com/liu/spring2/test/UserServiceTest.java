package com.liu.spring2.test;

import com.liu.spring.pojo.User;
import com.liu.spring2.dao.SpringConfig;
import com.liu.spring2.dao.UserDao;
import com.liu.spring2.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author lms
 * @date 2021-04-11 - 14:15
 */
public class UserServiceTest {

    @Test
    public void add() {
        // 加载配置文件（加载的时候就会默认创建对象），使用的是注解的方式
        ApplicationContext context = new ClassPathXmlApplicationContext("bean10.xml");
        // 获取创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("userService = " + userService);
        userService.add();

//        UserDao userDao = context.getBean("userDao", UserDao.class);
//        userDao.show();
//        System.out.println("userDao = " + userDao);
    }



    // 基于全注解的模式进行开发
    @Test
    public void test2() {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 获取创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("userService = " + userService);
        userService.add();

    }
}