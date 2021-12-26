package com.liu.service.impl;

import com.liu.dao.BookDao;
import com.liu.dao.OrderDao;
import com.liu.dao.OrderItemDao;
import com.liu.dao.impl.BookDaoImpl;
import com.liu.dao.impl.OrderDaoImpl;
import com.liu.dao.impl.OrderItemDaoImpl;
import com.liu.pojo.*;
import com.liu.service.OrderService;

import java.net.Inet4Address;
import java.util.Date;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-08 - 16:07
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();


    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 生成订单号(每个订单号都是未知的，所以使用时间 + 用户id)
        String orderId = System.currentTimeMillis()+""+userId;
        // 1.创建订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        // 保存订单项
        orderDao.saveOrder(order);

        // 模拟异常的现象
        // int rest = 12 / 0;

        // 遍历购物车中每一个商品项并将其转换成为订单项从而保存到数据库中
        for (Map.Entry<Integer, CartItem>entry: cart.getItems().entrySet()){
            // 获取购物车中的每一个商品项(这里的entry是一个键值对)
            CartItem cartItem = entry.getValue();
            // 将商品项转为订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            // 将订单项保存到数据库中
            orderItemDao.saveOrderItem(orderItem);

            // 查询被购买的商品信息
            Book book = bookDao.queryBookById(cartItem.getId());
            // 将商品的销量和库存进行修改
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        // 清空购物车而
        cart.clear();
        return orderId;
    }
}
