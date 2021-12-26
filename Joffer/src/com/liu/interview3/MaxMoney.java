package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-17 - 9:36
 * <p>
 * 打家劫舍：找出数组中的最大值，相邻位置不能选择，
 * 比如： [1,2,3,1]   max = 1+3 = 4
 * [2,7,9,3,1]  max = 2 + 9 + 1 = 12
 */
public class MaxMoney {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 3, 1};
//        int maxMoney = maxMoney(arr, arr.length - 1);
        int maxMoney = maxMoney2(arr);
        System.out.println("maxMoney = " + maxMoney);
    }

    /**
     * 动态规划：
     *  0、设置dp[]数组
     *  1、找到函数的出口
     *  2、确定转移函数
     * @param arr
     * @return
     */
    public static int maxMoney2(int arr[]) {
        if (arr == null){
            return -1;
        }
        if (arr.length == 0){
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        // 转移函数 dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1])
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        return dp[arr.length-1];
    }


    /**
     * 递归算法
     * 当前数组中的最大值:  arr[index-2]
     * @param arr   数组
     * @param index 从 0 - index中的最大值
     * @return
     */
    public static int maxMoney(int arr[], int index) {
        if (arr.length == 0 || index < 0) {
            return -1;
        }
        if (index == 0) {
            return arr[0];
        }
        return Math.max(maxMoney(arr, index - 2) + arr[index], maxMoney(arr, index - 1));
    }

}
