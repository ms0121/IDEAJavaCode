package com.liuboot.boot;

import com.liuboot.boot.config.IocConfig;
import com.liuboot.boot.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lms
 * @date 2021-09-26 - 19:04
 */
public class Starter {
    public static void main(String[] args) {
        // 等价于之前的ApplicationContext(xx.xml路径)
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(IocConfig.class);

        // 获取IOC容器中的bean
//        IocConfig iocConfig = ac.getBean(IocConfig.class);

        UserService userService = ac.getBean(UserService.class);
        userService.test();
    }
}
