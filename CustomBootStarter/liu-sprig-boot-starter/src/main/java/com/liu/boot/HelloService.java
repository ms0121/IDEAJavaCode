package com.liu.boot;

/**
 * @author lms
 * @date 2021-11-09 - 19:55
 * 直接就是我们工作中的业务代码
 */
public class HelloService {
    // 导入helloProperties对象，执行业务方法
    private HelloProperties helloProperties;

    public HelloService(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    // 执行业务方法
    public String sayHello() {
        return "hello:  " + helloProperties.getName() + "  ;年龄:  " + helloProperties.getAge();
    }
}
