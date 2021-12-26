package com.liu.model.factory.abstractF;

/**
 * @author lms
 * @date 2021-08-30 - 19:41
 * 抽象工厂：里面包含了手机和路由器这两个接口
 *        然后设计两个小米工厂和华为工厂，实现这个接口，即他们就可以生产这两个组件
 */
public interface ProductFactory {

    IphoneProduct getPhone();

    RouterProduct getRouter();

}
