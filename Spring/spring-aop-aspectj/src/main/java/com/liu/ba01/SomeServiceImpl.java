package com.liu.ba01;

/**
 * @author lms
 * @date 2021-04-26 - 16:02
 */

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        System.out.println("========目标方法doSome执行了======");
    }
}
