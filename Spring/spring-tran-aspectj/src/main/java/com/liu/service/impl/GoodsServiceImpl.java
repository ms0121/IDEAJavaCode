package com.liu.service.impl;

import com.liu.dao.GoodsDao;
import com.liu.dao.SaleDao;
import com.liu.entity.Goods;
import com.liu.entity.Sale;
import com.liu.exce.NotEnoughException;
import com.liu.service.GoodsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lms
 * @date 2021-04-27 - 15:58
 */
public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }


    @Override
    public void buy(Integer goodId, Integer nums) {
        // 记录销售信息，想sale表添加记录,生成订单记录
        System.out.println("========插入开始=========");
        Sale sale = new Sale();
        sale.setGid(goodId);
        sale.setNum(nums);
        saleDao.insertSale(sale);

        // 更新库存
        // 如果没有事务，即使程序出现了异常，上面的代码仍然会执行成功，导致出现数据的错误,
        // 所以该方法需要添加事务的方法
        Goods goods = goodsDao.selectGoods(goodId);
        if (goods == null){
            throw new NotEnoughException("编号: " + goodId + "商品不存在!");
        }else if (goods.getAmount() < nums){
            throw new NotEnoughException("编号: " + goodId + "商品库存不足!");
        }

        Goods goods1 = new Goods();
        goods1.setId(goodId);
        goods1.setAmount(nums);
        // 更新数据库的信息
        goodsDao.updateGoods(goods1);
        System.out.println("=======执行完成======");
    }

}









