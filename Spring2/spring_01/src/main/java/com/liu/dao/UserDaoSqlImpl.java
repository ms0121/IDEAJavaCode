package com.liu.dao;

/**
 * @author lms
 * @date 2021-09-09 - 16:10
 */
public class UserDaoSqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("sql - 查询当前所有来自于sql的user信息！！！");
    }
}
