package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:43
 */
public class XiaomiFactory implements ProductFactory {
    @Override
    public IphoneProduct getPhone() {
        return new XiaomiPhone();
    }

    @Override
    public RouterProduct getRouter() {
        return new XiaomiRouter();
    }
}
