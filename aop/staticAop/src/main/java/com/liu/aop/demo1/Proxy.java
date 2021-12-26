package com.liu.aop.demo1;

/**
 * @author lms
 * @date 2021-10-03 - 18:13
 */
public class Proxy implements RentHouse {
    // 目标对象（不推荐使用构造器的方式进行目标对象的注入）
    private RentHouse target;

    // 不推荐使用构造器注入的方式
    //    public Proxy(RentHouse target) {
    //        this.target = target;
    //    }

    public void setTarget(RentHouse target) {
        this.target = target;
    }

    @Override
    public void rent() {
        System.out.println("正在紧锣密鼓的找房子............");
        target.rent();
        System.out.println("签合同...............");
    }
}
