package com.liu.test;

import com.liu.bean.Person;
import com.liu.config.MainConfig;
import com.liu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

/**
 * @author lms
 * @date 2021-05-07 - 9:04
 */

@Component @Controller @Service @Repository


// 测试使用Person的标签方式
public class Ioc_TestPerson {

    public static void main(String[] args) {
//        // 方法1：注解式开发要求使用配置文件的方式直接从spring容器中获取对应的bean对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        // 也可以使用类对象的方式
////        Person person = context.getBean(Person.class);
//        // 直接使用配置文件（bean.xml）中的id属性进行获取对象
//        Person person = (Person) context.getBean("person");
//        System.out.println("person = " + person);
//        System.out.println("==================================");

        // 方法2：使用配置类的方式进行创建对象
        ApplicationContext context1 = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person1 = (Person) context1.getBean(Person.class);
        System.out.println("person1 = " + person1);

        String[] personType = context1.getBeanNamesForType(Person.class);
        for (String s : personType) {
            System.out.println("s = " + s);
        }
    }
}
