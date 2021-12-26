package com.liuboot.boot.service;

import com.liuboot.boot.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-09-26 - 19:01
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;


    public void test(){
        System.out.println("userService test()............");
        userDao.test();
    }
}
