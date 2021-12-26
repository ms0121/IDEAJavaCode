package com.liu.service.Impl;

import com.liu.service.SomeService;

import java.util.Date;

/**
 * @author lms
 * @date 2021-04-26 - 10:37
 */

// 常规的方法
public class SomeServiceImpl2 implements SomeService {
    @Override
    public void doSome() {
        System.out.println("时间: " + new Date());
        System.out.println("执行了doSome方法");
        System.out.println("事务实现了");
    }

    @Override
    public void doOther() {
        System.out.println("时间: " + new Date());
        System.out.println("执行了doOther方法");
        System.out.println("事务实现了");
    }
}
