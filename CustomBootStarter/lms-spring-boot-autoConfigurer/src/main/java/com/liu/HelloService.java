package com.liu;

/**
 * @author lms
 * @date 2021-11-03 - 22:29
 * 实际项目中的业务类，也是我们真正需要的项目类
 */
public class HelloService {
    // 导入helloProperties对象，执行业务方法
    private HelloProperties helloProperties;

    public HelloService(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    // 执行业务方法
    public String sayHello() {
        return "hello:" + helloProperties.getName() + ";年龄:" + helloProperties.getAge();
    }
}
