package com.liu;

import com.liu.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-26 - 16:25
 */
public class AopTest4 {

    @Test
    public void test3() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService someService = (SomeService) context.getBean("someService");
        // 通过代理的对象执行方法，实现目标方法执行时，增强了功能
        String res = someService.doFirst("zhangsan", 21);
        // 上面的执行语句实际上执行的是: String res = someService.myAround("zhangsan", 21);
        System.out.println("res = " + res);
    }

}
