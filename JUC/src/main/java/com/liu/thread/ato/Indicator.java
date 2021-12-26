package com.liu.thread.ato;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lms
 * @date 2021-10-10 - 8:05
 * 模拟请求的计算器：分别记录总的访问请求数，成功的请求数，失败的请求数
 * 因为只有一个计算器，所以将计数器设置为单例模式
 * 使用原子类进行计算:
 */
//使用饿汉式
public class Indicator {
    // 1.构造器私有化
    private Indicator() {
    }

    // 创建实例
    private static final Indicator instance = new Indicator();

    // 返回产生的变量实例
    public static Indicator getInstance(){
        return instance;
    }


    private final AtomicLong allRequest = new AtomicLong(0);
    private final AtomicLong successRequest = new AtomicLong(0);
    private final AtomicLong failureRequest = new AtomicLong(0);

    public void addAllRequest() {
        allRequest.incrementAndGet();
    }

    public void addSuccessRequest() {
        successRequest.incrementAndGet();
    }

    public void addFailureRequest() {
        failureRequest.incrementAndGet();
    }

    public AtomicLong getAllRequest() {
        return allRequest;
    }

    public AtomicLong getSuccessRequest() {
        return successRequest;
    }

    public AtomicLong getFailureRequest() {
        return failureRequest;
    }
}
