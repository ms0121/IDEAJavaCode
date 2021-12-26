package com.liu;

import com.liu.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lms
 * @date 2021-04-27 - 16:25
 */
public class BuyTest {

    @Test
    public void test1() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        GoodsService goodsService = (GoodsService) context.getBean("goodsService");
        goodsService.buy(1001, 2);
    }
}
