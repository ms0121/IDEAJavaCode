package com.liu.service;

import com.liu.dao.UserDaoMysqlImpl;
import com.liu.dao.UserDaoOracleImpl;
import com.liu.dao.UserDaoSqlImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-09-09 - 16:04
 */
class UserServiceImplTest {

    public static void main(String[] args) {
//        方式1
//        UserService userService = new UserServiceImpl();
//        // 将userService强转转为UserServiceImpl类型
//        ((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();

//        方式2：
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUser();
    }
}
