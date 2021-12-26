package com.liu.spring.demo4;

import com.liu.spring.demo2.Course;
import com.sun.deploy.net.cookie.CookieUnavailableException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;

/**
 * @author lms
 * @date 2021-04-11 - 10:21
 */
public class CatTest {
    public static void main(String[] args) {

        // 加载配置文件（会自动的创建相应的对象）
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        // 获取配置文件创建的对象
        Course course = context.getBean("cat", Course.class);
        System.out.println("course = " + course);
    }
}
