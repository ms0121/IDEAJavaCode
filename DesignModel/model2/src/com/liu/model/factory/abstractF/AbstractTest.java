package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:44
 */
public class AbstractTest {

    public static void main(String[] args) {
        System.out.println("=================小米工厂===================");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IphoneProduct phone = xiaomiFactory.getPhone();
        RouterProduct router = xiaomiFactory.getRouter();
        phone.name();
        phone.send();
        router.name();
        router.type();


        System.out.println("=================华为工厂===================");
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IphoneProduct phone1 = huaweiFactory.getPhone();
        RouterProduct router1 = huaweiFactory.getRouter();
        phone1.name();
        phone1.send();
        router1.name();
        router1.type();

    }

}
