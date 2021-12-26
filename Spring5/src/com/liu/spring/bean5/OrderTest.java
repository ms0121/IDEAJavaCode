package com.liu.spring.bean5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-11 - 11:07
 */
public class OrderTest {
    public static void main(String[] args) {

        // 加载配置文件信息
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        // 获取配置文件创建的对象
        Order order = context.getBean("order", Order.class);
        System.out.println("4. 获取配置文件创建的对象");
        System.out.println(order);
        // 手动销毁对象,需要进行类型的强转转换
        context.close();
    }
}
