package com.liu.service;

import com.liu.dao.UserDao;

/**
 * @author lms
 * @date 2021-09-09 - 16:03
 */
public class UserServiceImpl implements UserService {
// 由于要使用到oracle中的数据库
//    private UserDao userDao = new UserDaoMysqlImpl();

// 由于使用的是oracle中的数据
//    private UserDao userDao = new UserDaoOracleImpl();
// 这种方式的话代码耦合度高，牵一发而动全身，都需要进行修改代码，不好
//    private UserDao userDao = new UserDaoSqlImpl();


    private UserDao userDao;

    // 利用set方法进行动态的注入需要的具体的UserDaoImpl对象
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
