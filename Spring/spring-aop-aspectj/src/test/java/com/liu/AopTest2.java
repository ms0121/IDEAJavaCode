package com.liu;

import com.liu.ba02.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-26 - 16:25
 */
public class AopTest2 {

    @Test
    public void test2() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService someService = (SomeService) context.getBean("someService");
        // 通过代理的对象执行方法，实现目标方法执行时，增强了功能
        String res = someService.doOther("zhangsan", 21);
        System.out.println("res = " + res);
    }

}
