package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-01 - 21:27
 * 静态代理的实现
 */
public class StaticProxy {
    public static void main(String[] args) {
        ProxyClient proxyClient = new ProxyClient(new Tony());
        proxyClient.happyMarry();
    }
}

interface Marry{
    void happyMarry();
}


//被代理类
class Tony implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("Tony今天要结婚了");
    }
}

// 代理类
class ProxyClient implements Marry{

    private Tony tony;

    public ProxyClient(Tony tony) {
        this.tony = tony;
    }

    @Override
    public void happyMarry() {
        before();
        tony.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款......");
    }

    private void before() {
        System.out.println("结婚之前，布置现场......");
    }
}


