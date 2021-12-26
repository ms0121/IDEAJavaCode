package com.liu;

import com.liu.aop.MathCalculator;
import com.liu.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lms
 * @date 2021-05-08 - 10:29
 */
public class aop_MainConfigOfAop {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        // 不要自己直接创建对象进行调用
//        MathCalculator mathCalculator = new MathCalculator();
//        int div = mathCalculator.div(10, 0);
//        System.out.println("div = " + div);
        MathCalculator bean = context.getBean(MathCalculator.class);
        bean.div(10,5);
        context.close();
    }
}
