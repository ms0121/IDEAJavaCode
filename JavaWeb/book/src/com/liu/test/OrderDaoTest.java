package com.liu.test;

import com.liu.dao.OrderDao;
import com.liu.dao.impl.OrderDaoImpl;
import com.liu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lms
 * @date 2021-04-08 - 15:34
 */
public class OrderDaoTest {

    @Test
    public void saveOrder(){
        OrderDao orderDao = new OrderDaoImpl();
        int flag = orderDao.saveOrder(new Order("367",new Date(787784373L), new BigDecimal(99), 0, 3));
        System.out.println("flag = " + flag);
    }
}