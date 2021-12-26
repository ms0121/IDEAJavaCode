package com.liu.dao.impl;

import com.liu.dao.OrderItemDao;
import com.liu.pojo.OrderItem;

/**
 * @author lms
 * @date 2021-04-08 - 15:25
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(id,name,count,price,total_price,order_id)value(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getCount(),orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
