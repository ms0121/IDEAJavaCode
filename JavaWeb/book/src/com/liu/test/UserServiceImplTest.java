package com.liu.test;

import com.liu.pojo.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author lms
 * @date 2021-04-01 - 11:23
 */
public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        User user = new User("lisi", "li168", "lisi@qq.com");
        User user1 = new User("lms", "lms168", "lms@qq.com");
        userService.registerUser(user);
        userService.registerUser(user1);
    }

    @Test
    public void login() {
        User user = new User("lisi", "li168", "lisi@qq.com");
        User user1 = userService.login(user);
        System.out.println("user1 = " + user1);
    }

    @Test
    public void existUsername(){
        boolean flag = userService.existUsername("lms");
        System.out.println("flag = " + flag);
    }
}



