package com.liu.spring.service;

import com.liu.spring.dao.UserDao;

/**
 * @author lms
 * @date 2021-04-10 - 20:32
 */
public class UserService {


    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("UserService add()..............");
        userDao.update();
    }


}
