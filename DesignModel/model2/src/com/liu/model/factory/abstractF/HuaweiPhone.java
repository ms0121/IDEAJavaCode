package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:37
 */
public class HuaweiPhone implements IphoneProduct {
    @Override
    public void name() {
        System.out.println("华为手机");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void send() {
        System.out.println("华为手机发短信");
    }
}
