package com.liu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lms
 * @date 2021-05-08 - 11:45
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // 标识当前的方法是一个事务方法
    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入完成.........");
        // 加入异常的情况
        System.out.println(10 / 0);
    }
}
