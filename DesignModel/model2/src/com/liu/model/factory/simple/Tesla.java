package com.liu.model.factory.simple;

/**
 * @author lms
 * @date 2021-08-30 - 17:06
 */
public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
