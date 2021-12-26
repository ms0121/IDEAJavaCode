package com.liu.dao;

import com.liu.entity.Goods;

/**
 * @author lms
 * @date 2021-04-27 - 15:38
 */
public interface GoodsDao {
    int updateGoods(Goods goods);
    Goods selectGoods(Integer goodsId);
}
