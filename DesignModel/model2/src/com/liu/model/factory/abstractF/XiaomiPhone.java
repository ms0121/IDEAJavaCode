package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:36
 */
public class XiaomiPhone implements IphoneProduct {
    @Override
    public void name() {
        System.out.println("小米手机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void send() {
        System.out.println("小米手机发短信");
    }
}
