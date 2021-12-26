package com.liu.dao.impl;

import com.liu.dao.OrderDao;
import com.liu.pojo.Order;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-08 - 15:25
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {


    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id)values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryMyOrders(int userId) {
        String sql = "";
        return null;
    }
}





