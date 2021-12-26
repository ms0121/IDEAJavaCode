package com.liu.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-11 - 9:48
 */
public class BookTest {
    public static void main(String[] args) {

        // 加载配置文件（会自动的创建相应的对象）
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        // 获取配置文件中创建的对象
        // 普通的bean，（普通 bean ：在配置文件中定义 bean  类型就是返回类型 ）
        // 表示多实例还是单实例对象
        Book book = context.getBean("book", Book.class);
        Book book1 = context.getBean("book", Book.class);
        // System.out.println("book = " + book);

        // 默认使用的是单实例
        //        在 Spring  里面 ，默认情况下，bean  是单实例对象

        //        如何设置单实例还是多实例
        //        （1）在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例
        //        （2）scope 属性值:
        //            第一个值  默认值，singleton，表示是单实例对象
        //            第二个值  prototype，表示是多实例对象


        //        singleton 和 prototype 区别
        //            第一  singleton 单实例，prototype 多实例
        //            第二  设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象
        //            设置 scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建 对象，在调用
        //            getBean 方法时候创建多实例对象

        System.out.println("book = " + book.hashCode());
        System.out.println("book1 = " + book1.hashCode());


    }
}
