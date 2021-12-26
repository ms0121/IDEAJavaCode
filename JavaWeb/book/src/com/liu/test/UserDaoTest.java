package com.liu.test;

import com.liu.dao.UserDao;
import com.liu.dao.impl.BaseDao;
import com.liu.dao.impl.UserDaoImpl;
import com.liu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lms
 * @date 2021-04-01 - 10:45
 */
public class UserDaoTest {

    public UserDao userDao = new UserDaoImpl();

    @Test
    public void queryForUsername() {
        String username = "admin";
        User user = userDao.queryForUsername(username);
        if (user == null){
            System.out.println("用户名可以用!");
        } else {
            System.out.println("用户名不可以用!");
        }
        System.out.println("user = " + user);
    }

    @Test
    public void queryForUsernameAndPassword() {
        String username = "admin";
        String password = "admin";
        User user = userDao.queryForUsernameAndPassword(username, password);
        if (user == null){
            System.out.println("用户名可以用!");
        } else {
            System.out.println("用户名不可以用!");
        }
        System.out.println("user = " + user);
    }

    @Test
    public void saveUser() {
        User user = new User("zhangsan", "123456", "zhansgan@qq.com");
        int flag = userDao.saveUser(user);
        System.out.println("flag = " + flag);
    }
}