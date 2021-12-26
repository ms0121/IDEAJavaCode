package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:39
 */
public class XiaomiRouter implements RouterProduct {
    @Override
    public void name() {
        System.out.println("小米路由器");
    }

    @Override
    public void type() {
        System.out.println("小米-001");
    }
}
