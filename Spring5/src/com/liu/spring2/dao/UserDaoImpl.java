package com.liu.spring2.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-04-11 - 14:18
 */

//@Repository
@Repository(value = "userDaoImpl")  // 用于指定具体的实现类
public class UserDaoImpl implements UserDao {
    public void show() {
        System.out.println("使用注解的方式进行创建对象");
    }
}
