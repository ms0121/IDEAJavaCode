package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.dao.impl.UserDaoImpl;
import com.liu.pojo.User;
import com.liu.service.UserService;

import java.awt.geom.FlatteningPathIterator;

/**
 * @author lms
 * @date 2021-04-01 - 11:14
 */
public class UserServiceImpl implements UserService {

    // 所有的操作都要在数据库上进行，但是操作数据库是由dao来实现的，所以需要创建dao的类
    private UserDao userDao = new UserDaoImpl();

    // 实现具体的对数据库的操作
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryForUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryForUsername(username) == null){
            return false;
        }else {
            return true;
        }
    }
}
