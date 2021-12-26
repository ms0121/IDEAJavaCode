package com.liu.dao;

/**
 * @author lms
 * @date 2021-09-09 - 16:02
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql - 查询当前所有来自于msql的user信息！！！");
    }
}
