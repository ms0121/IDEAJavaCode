package com.liu.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author lms
 * @date 2021-05-07 - 14:15
 */

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

    // 返回一个Color对象，这个对象会被添加到容器之中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }


    // 设置返回的是否是单例模式
    //true：表示每次都是从容器中获取已经创建好同一份dean
    //false：多实例，每次获取都需要进行创建一个新的bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}
