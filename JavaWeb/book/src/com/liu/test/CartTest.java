package com.liu.test;

import com.liu.pojo.Cart;
import com.liu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-04-07 - 20:33
 */
public class CartTest {

    private Cart cart = new Cart();

    @Test
    public void addItem() {
        // 每个商品都有唯一的id信息
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(39.00),new BigDecimal(39.00)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(39.00),new BigDecimal(39.00)));
        cart.addItem(new CartItem(2,"Python",1,new BigDecimal(20.00),new BigDecimal(20.00)));
        cart.addItem(new CartItem(3,"C++",1,new BigDecimal(28.00),new BigDecimal(28.00)));

        System.out.println("cart = " + cart);

    }

    @Test
    public void deleteItem() {
        cart.deleteItem(2);
        System.out.println("cart = " + cart);
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
    }
}