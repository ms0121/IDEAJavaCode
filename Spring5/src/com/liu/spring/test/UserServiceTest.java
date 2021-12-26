package com.liu.spring.test;

import com.liu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-10 - 20:07
 */
public class UserServiceTest {

    @Test
    public void add() {
        // 以前的写法
        //        UserService userService = new UserServiceImpl();
        //        userService.add();


        // 使用了spring注入的写法
        // 1.加载spring配置文件信息(加载配置文件的时候就会自动的创建对象)
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        // 2.获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}








