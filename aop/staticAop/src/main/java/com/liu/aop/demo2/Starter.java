package com.liu.aop.demo2;

/**
 * @author lms
 * @date 2021-10-03 - 20:17
 */
public class Starter {
    public static void main(String[] args) {
        UserserviceImpl userservice = new UserserviceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userservice);
        userServiceProxy.add();
    }
}
