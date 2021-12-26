package com.liu.juc.single;

/**
 * @author lms
 * @date 2021-09-06 - 15:19
 */
public class StaticSimple {

    // 构造器私有化
    private StaticSimple(){

    }

    // 静态内部类实现单例模式
    public static class InnerClass{
        private static final StaticSimple STATIC_SIMPLE = new StaticSimple();
    }

    // 返回实例对象
    public static StaticSimple getInstance(){
        return InnerClass.STATIC_SIMPLE;
    }

}
