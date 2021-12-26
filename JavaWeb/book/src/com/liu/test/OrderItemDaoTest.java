package com.liu.test;

import com.liu.dao.OrderItemDao;
import com.liu.dao.impl.OrderItemDaoImpl;
import com.liu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-04-08 - 15:47
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem(){
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(1,"山鸡是如何炼成的",1,new BigDecimal(100),new BigDecimal(100),"2"));
        orderItemDao.saveOrderItem(new OrderItem(2,"平凡的世界",1,new BigDecimal(120),new BigDecimal(120),"3"));
        orderItemDao.saveOrderItem(new OrderItem(3,"java从入门到精通",1,new BigDecimal(80),new BigDecimal(80),"3"));
        System.out.println("执行完毕");
    }

}