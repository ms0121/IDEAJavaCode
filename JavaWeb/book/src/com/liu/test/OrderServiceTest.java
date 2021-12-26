package com.liu.test;

import com.liu.pojo.Cart;
import com.liu.pojo.CartItem;
import com.liu.service.OrderService;
import com.liu.service.impl.OrderServiceImpl;
import org.junit.Test;

import javax.print.attribute.standard.OrientationRequested;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author lms
 * @date 2021-04-08 - 16:32
 */
public class OrderServiceTest {

    @Test
    public void createOrder(){
        OrderService orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        // 每个商品都有唯一的id信息
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(39.00),new BigDecimal(39.00)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(39.00),new BigDecimal(39.00)));
        cart.addItem(new CartItem(2,"Python",1,new BigDecimal(20.00),new BigDecimal(20.00)));
        cart.addItem(new CartItem(3,"C++",1,new BigDecimal(28.00),new BigDecimal(28.00)));
        // 生成订单
        orderService.createOrder(cart, 1);
    }
}