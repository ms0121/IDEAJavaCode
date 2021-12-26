package com.liu.model.proxy.staticProcy;

/**
 * @author lms
 * @date 2021-08-31 - 20:40
 */
public class Client {

    public static void main(String[] args) {
        // 房东找到一个具体的房东的房子
        Host host = new Host();
        // 找到一个具体的方法
        ProcyHost procyHost = new ProcyHost(host);
        // 房东带着你去租房子
        procyHost.rent();
    }
}
