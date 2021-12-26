package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:40
 */
public class HuaweiRouter implements RouterProduct{
    @Override
    public void name() {
        System.out.println("华为路由器");
    }

    @Override
    public void type() {
        System.out.println("华为-001");
    }
}
