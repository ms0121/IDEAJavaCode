package com.liu.aop.demo2;

/**
 * @author lms
 * @date 2021-10-03 - 20:16
 */
public class UserserviceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("=========add=========");
    }
    @Override
    public void delete() {
        System.out.println("=========delete=========");
    }
    @Override
    public void update() {
        System.out.println("=========update=========");
    }

    @Override
    public void query() {
        System.out.println("=========query=========");
    }
}
