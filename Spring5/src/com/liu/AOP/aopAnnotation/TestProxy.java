package com.liu.AOP.aopAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-12 - 13:12
 */
public class TestProxy {
    public static void main(String[] args) {
        // 加载配置文件（会创建相应的对象）
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        // 获取配置文件的对象
        User user = context.getBean("user", User.class);
        // 如果有多个增强类对同一个方法进行了增强，那么就可以使用order()的值进行设置优先级的顺序
        user.add();
    }
}
