package com.liu.dao;

import com.liu.pojo.Order;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-08 - 15:23
 */
public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> queryMyOrders(int userId);
}
