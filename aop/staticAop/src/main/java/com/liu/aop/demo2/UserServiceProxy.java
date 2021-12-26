package com.liu.aop.demo2;

/**
 * @author lms
 * @date 2021-10-03 - 20:37
 */
public class UserServiceProxy implements UserService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log();
        userService.add();
    }

    @Override
    public void delete() {
        log();
        userService.delete();
    }

    @Override
    public void update() {
        log();
        userService.update();
    }

    @Override
    public void query() {
        log();
        userService.query();
    }

    // 给每个方法添加一个日志功能
    public void log() {
        System.out.println("======log=======");
    }
}
