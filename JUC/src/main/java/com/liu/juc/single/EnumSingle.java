package com.liu.juc.single;

/**
 * @author lms
 * @date 2021-09-06 - 15:51
 */

//枚举单例。使用反射也无法进行破坏，另外三个使用反射的方式可以破坏单例模式
public enum  EnumSingle {

    INSTANCE;

    public static EnumSingle getInstance(){
        return INSTANCE;
    }
}
