package com.liu.boot;

import com.liu.boot.bean.Pet;
import com.liu.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.jws.soap.SOAPBinding;

@SpringBootApplication
public class Boot01Application {

    public static void main(String[] args) {
        // 1、获取当前的容器对象
        ConfigurableApplicationContext run = SpringApplication.run(Boot01Application.class, args);

        // 2、获取容器中所有组件的名字
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }

        // 获取容器中组件的数量
        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount = " + beanDefinitionCount);

        // 查看容器中指定类型的组件的个数
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("beanNamesForType = " + beanNamesForType.length);
        System.out.println("============================================");

        // 3、直接从容器中获取指定类型的容器
        User user = run.getBean(User.class);
        Pet pet = run.getBean(Pet.class);
        System.out.println("user = " + user);
        System.out.println("pet = " + pet);
    }

}
