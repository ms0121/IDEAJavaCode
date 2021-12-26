package com.liu.pojo;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-04-07 - 19:40
 */

/**
 * CartItem代表的是购物车中的每一条数据信息，即拥有商品的id，商品的名称，该商品的购买数量，单价，总价
 */
public class CartItem {
    private int id;
    private String name;
    private int count;
    private BigDecimal price;
    private  BigDecimal totalPrice;

    public CartItem(int id, String name, int count, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
