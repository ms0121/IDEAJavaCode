package com.liu.boot;

import com.liu.boot.bean.Pet;
import com.liu.boot.bean.User;
import com.liu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lms
 * @date 2021-05-09 - 10:56
 * 主程序类：所有程序的主入口
 * @SpringBootApplication：表示当前的应用是一个springboot的程序
 */
//@SpringBootApplication 这句话等价于下面的三个注解

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.liu.boot")
public class MainApplication {

    public static void main(String[] args) {
        // 1.返回我们的ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);

        // 2.查看容器中的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }

        // 3.从容器中获取组件信息
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println("(tom01 == tom02) = " + (tom01 == tom02));
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println("bean = " + bean);
//
//
//        // @Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件
//        // 在容器中是否存在，如果存在，就不创建，反之，要保持单实例的模式
//        User user1 = run.getBean("user01", User.class);
//        User user2 = bean.user01();
//        System.out.println("(user1 == user2) = " + (user1 == user2));


//        4、conditional注解的使用
        boolean tom = run.containsBean("tom");
        System.out.println("容器中是否存在tom组件: " + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中是否存在user01组件: " + user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中是否存在tom22组件: " + tom22);


//        5.导入配置文件bean.xml的方式
        boolean haha = run.containsBean("user02");
        boolean hehe = run.containsBean("cat2");
        System.out.println("haha：" + haha);//true
        System.out.println("hehe：" + hehe);//true


    }
}
