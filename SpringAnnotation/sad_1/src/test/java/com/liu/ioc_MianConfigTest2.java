package com.liu;

import com.liu.bean.Person;
import com.liu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-05-07 - 11:17
 */
public class ioc_MianConfigTest2 {

    // 获取ioc容器对象
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport() {
        printBeans(context);
        // 工厂bean获取的默认是调用getObject创建的对象
        Object bean = context.getBean("colorFactoryBean");
        Object bean1 = context.getBean("colorFactoryBean");
        System.out.println("bean = " + bean);
        System.out.println("bean.getClass() = " + bean.getClass());
        System.out.println(bean == bean1);

        // 获取ColorFactoryBean对象的，需要在类的前面添加 & 符号
        Object bean2 = context.getBean("&colorFactoryBean");
        System.out.println("bean2 = " + bean2);

    }

    public void printBeans(AnnotationConfigApplicationContext context1) {
        // 获取容器中所有的bean对象名
        String[] beanNamesForType = context1.getBeanDefinitionNames();
        for (String s : beanNamesForType) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void test3() {
        // 获取容器中指定类型的所有的bean对象
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println("s = " + s);
        }
    }





    @Test
    public void test2() {
        // 默认使用的是单实例的对象
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
        Person person1 = (Person) context.getBean("person");
        System.out.println("flag = " + person1.equals(person));
    }

    @Test
    public void test1() {
        // 使用的是配置文件bean.xml
        // 多实例的意思就是每次从spring容器中获取的对象是不同的，（hascode值不一样），
//        单实例：返回的都是同一个对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person.hashCode());
        Person person1 = (Person) context.getBean("person");
        System.out.println("person1 = " + person1.hashCode());
        System.out.println(person==person1);

    }


}
