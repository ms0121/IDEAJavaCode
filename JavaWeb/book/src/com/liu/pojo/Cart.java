package com.liu.pojo;

import javax.print.attribute.standard.MediaSize;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author lms
 * @date 2021-04-07 - 19:38
 */
public class Cart {
//    private int totalCount;
//    private BigDecimal totalPrice;
    // 商品的id作为map的键key，因为每个商品的id是唯一的
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品信息
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 查询在Map中是否存在该CartItem对象
        CartItem item = items.get(cartItem.getId());
        // 如果不存在，则将该CartItem对象的id，CartItem插入到map中
        if (item == null){
            items.put(cartItem.getId(), cartItem);
        }else {
            // 存在，则设置当前的item的数量加上1，并设置该item对应数量的总价格
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    /**
     * 删除商品信息
     *
     * @param id
     */
    public void deleteItem(int id) {
        items.remove(id);
    }

    /**
     * 清空购物车的商品
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品的数量
     * @param id
     * @param count
     */
    public void updateCount(int id, int count) {
        CartItem item = items.get(id);
        // 判断是否存在指定id的那个商品
        if (item != null){
            // 设置新的购买数量
            item.setCount(count);
            // 自动更新总的商品数量的总价格
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    public int getTotalCount() {
        Integer totalCount = 0;
        // 取出每一个键值对
        for (Map.Entry<Integer, CartItem>entry: items.entrySet()) {
            // entry.getValue()表示的是每一个CartItem商品项
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem>entry: items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
