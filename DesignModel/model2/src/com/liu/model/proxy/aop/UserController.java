package com.liu.model.proxy.aop;

/**
 * @author lms
 * @date 2021-08-31 - 20:54
 */
public class UserController {

    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 不使用代理的方式
        userServiceImpl.add();
        System.out.println("==========================\n\n");

        // 使用了代理的方式（aop思想）
        UserServiceImplProxy userServiceImplProxy = new UserServiceImplProxy();
        userServiceImplProxy.setUserServiceImpl(userServiceImpl);

        userServiceImplProxy.delete();

    }

}
