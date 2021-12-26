package com.liu.juc.single;

/**
 * @author lms
 * @date 2021-09-06 - 15:16
 */
//单例模式 -- 饿汉式
public class HungrySingle {

    // 构造器私有化
    public HungrySingle(){

    }

    // 直接创建实例对象
    private final static HungrySingle hungrySingle = new HungrySingle();

    // 创建获取实例的方法
    public static HungrySingle getInstance(){
        return hungrySingle;
    }
}
