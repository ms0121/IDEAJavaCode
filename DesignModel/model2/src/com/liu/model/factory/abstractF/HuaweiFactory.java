package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:44
 */
public class HuaweiFactory implements ProductFactory {
    @Override
    public IphoneProduct getPhone() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct getRouter() {
        return new HuaweiRouter();
    }
}
