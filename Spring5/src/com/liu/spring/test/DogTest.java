package com.liu.spring.test;

import com.liu.spring.pojo.Dog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-11 - 8:24
 */
public class DogTest {

    @Test
    public void testDog() {
        // 获取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        // 获取配置文件创建的对象
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println("dog = " + dog);
    }
}
