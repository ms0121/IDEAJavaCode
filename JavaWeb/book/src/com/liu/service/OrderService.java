package com.liu.service;

import com.liu.pojo.Cart;

/**
 * @author lms
 * @date 2021-04-08 - 16:06
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer id);
}
