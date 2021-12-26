package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-15 - 22:15
 */
public class NC7 {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(arr);
        System.out.println("i = " + i);
    }

    public static int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0], maxPri = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            maxPri = Math.max(prices[i] - min, maxPri);
        }
        return maxPri;
    }

}
