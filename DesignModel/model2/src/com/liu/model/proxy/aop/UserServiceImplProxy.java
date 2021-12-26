package com.liu.model.proxy.aop;

/**
 * @author lms
 * @date 2021-08-31 - 20:57
 */
public class UserServiceImplProxy implements UserService {

    private UserServiceImpl userServiceImpl;

    // 然后在代理类中注入咋们要代理的类即可
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    // 需要添加的日记方法，咋们直接横插进入方法中即可
    public void log(String msg){
        System.out.println("【debug】当前执行了" + msg + "()方法");
    }

    @Override
    public void add() {
        // 横向插入日记的方法
        log("add");
        userServiceImpl.add();
    }

    @Override
    public void delete() {
        log("delete");
        userServiceImpl.delete();
    }

    @Override
    public void update() {
        log("update");
        userServiceImpl.update();
    }

    @Override
    public void query() {
        log("query");
        userServiceImpl.query();
    }
}
