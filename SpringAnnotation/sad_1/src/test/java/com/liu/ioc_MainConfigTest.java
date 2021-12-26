package com.liu;

import com.liu.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lms
 * @date 2021-05-07 - 9:49
 */
public class ioc_MainConfigTest {

    @Test
    public void test1(){
        // 查看当前的spring容器中的所有bean对象
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

}
