package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-14 - 17:22
 */
public class NC7 {
    public static void main(String[] args) {
        int[] price = {1,4,2};
        int profit = maxProfit(price);
        System.out.println("profit = " + profit);
    }

    public static int maxProfit (int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; i++) {
            // 记录遍历过的值中的最小值
            min = Math.min(prices[i], min);
            // 记录最小值和当前遍历值以及之前的最大差
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }
}
