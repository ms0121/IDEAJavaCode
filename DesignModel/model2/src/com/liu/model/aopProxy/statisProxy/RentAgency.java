package com.liu.model.aopProxy.statisProxy;

/**
 * @author lms
 * @date 2021-10-06 - 21:23
 */
public class RentAgency implements Rent{

    // 注入被代理的角色
    private Person target;

    // 使用set方式进行属性的注入
    public void setTarget(Person target) {
        this.target = target;
    }

    @Override
    public void rentHouse() {
        System.out.println("正在努力的找房子............");
        target.rentHouse();
        System.out.println("有时间就签一下合同吧...........");
    }

}
