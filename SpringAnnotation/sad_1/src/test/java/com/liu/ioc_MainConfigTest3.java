package com.liu;

import com.liu.bean.Person;
import com.liu.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lms
 * @date 2021-05-07 - 16:35
 */
public class ioc_MainConfigTest3 {
    // 获取ioc容器对象
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void testImport() {
        printBeans(context);
        // 获取容器中的person对象,直接通过id进行获取容器中的bean对象
        Person person = (Person) context.getBean("person");
        System.out.println("person = " + person);
        context.close();
    }

    public void printBeans(AnnotationConfigApplicationContext context1) {
        // 获取容器中所有的bean对象名
        String[] beanNamesForType = context1.getBeanDefinitionNames();
        for (String s : beanNamesForType) {
            System.out.println("s = " + s);
        }
    }
}
