package com.liu.aop.demo1;

/**
 * @author lms
 * @date 2021-10-03 - 18:11
 * 实现静态代理的方式：代理人和代理必须有相同的行为（方法），
 * 即代理帮代理人去执行代理人的行为，并可以额外的做一些事情
 */
public interface RentHouse {
    public void rent();
}
