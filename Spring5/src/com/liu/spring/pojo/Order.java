package com.liu.spring.pojo;

/**
 * @author lms
 * @date 2021-04-10 - 18:15
 */
public class Order {
    private String name;
    private int price;

    // 初始化对象的有参构造方法
    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
