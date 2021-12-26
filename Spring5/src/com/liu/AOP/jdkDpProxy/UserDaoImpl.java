package com.liu.AOP.jdkDpProxy;

/**
 * @author lms
 * @date 2021-04-11 - 19:53
 *
 * 现在的目的，在不修改实现类的方法的过程中。添加部分功能在下面的方法里面
 * 即：因为有实现类，可以使用JDK动态代理（创建接口实现类代理对象，增强类(给类添加部分功能)的方法）
 * 使用 Proxy 类创建接口代理对象
 */

public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
