package com.liu.transaction.test;

import com.liu.transaction.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lms
 * @date 2021-04-12 - 17:23
 */

@RunWith(SpringJUnit4ClassRunner.class) // 单元测试框架
@ContextConfiguration("classpath:jdbcBean2.xml") // 加载配置文件
public class AccountServiceTest {

    // Junit5整合Junit4，方便使用注解的方式进行测试的实现，使得测试的方法更加简便
    @Autowired
    private AccountService accountService;

    @Test
    public void test1() {
        accountService.accountMoney();
    }


    @Test
    public void accountMoney() {
        // 加载配置文件（加载的同时会创建对象）
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcBean2.xml");
        // 获取加载配置文件创建的对象
        AccountService accountService = context.getBean("accountService", AccountService.class);

        accountService.accountMoney();
    }

}