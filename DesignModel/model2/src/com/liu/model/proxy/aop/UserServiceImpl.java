package com.liu.model.proxy.aop;

/**
 * @author lms
 * @date 2021-08-31 - 20:53
 *
 * 现在要求给每个方法添加一个日记输出的功能，
 * 如果直接在下面的方法中进行修改是不允许的，也是公司的大忌。
 * 所以此时咋们就可以直接使用一个代理类进行实现
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("执行了add()方法。。。。。。。。。。");
    }

    @Override
    public void delete() {
        System.out.println("执行了delete()方法。。。。。。。。。。");
    }

    @Override
    public void update() {
        System.out.println("执行了update()方法。。。。。。。。。。");
    }

    @Override
    public void query() {
        System.out.println("执行了query()方法。。。。。。。。。。");
    }
}
