package com.liu;

import com.liu.config.MainConfigLife;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lms
 * @date 2021-05-07 - 14:44
 */
public class ioc_MainConfigLifeTest {
    @Test
    public void getB() {
        //  1。创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigLife.class);
        // 关闭容器
        context.close();
    }
}
