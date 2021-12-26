package com.liu.transaction.test;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @author lms
 * @date 2021-04-12 - 22:48
 */
public class UserTest {
    public static void main(String[] args) {
        // Spring5  核心容器支持 函数式风格 GenericApplicationContext
        // 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 调用Context的方法对象注册
        context.refresh();
        context.registerBean("user1", User.class, ()->new User());
        // 获取在Spring注册的对象
        User user = (User) context.getBean("user1");
        System.out.println("user = " + user);
    }
}
