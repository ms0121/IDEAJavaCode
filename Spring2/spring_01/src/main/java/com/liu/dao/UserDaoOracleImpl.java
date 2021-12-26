package com.liu.dao;

/**
 * @author lms
 * @date 2021-09-09 - 16:08
 */
public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle - 查询当前所有来自于oracle的user信息！！！");
    }
}
