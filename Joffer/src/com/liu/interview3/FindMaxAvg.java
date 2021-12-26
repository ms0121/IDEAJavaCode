package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-11 - 16:26
 * 给一个整数数组，找出平均数最大的并且长度为k的下标连续的子数组，
 * 并输出该最大平均数,
 */
public class FindMaxAvg {

    public static void main(String[] args) {
        int arr[] = {1, 12, -5, -6, 50, 3};
        double max = findMax(arr, 4);
        System.out.println("max = " + max);
    }

    /**
     * 使用滑动窗口的方式进行计算，固定首尾，每次向右移动，就减去第一个值，
     * 加上下一个值
     * @param nums
     * @param k
     * @return
     */
    public static double findMax(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        for (int i = 1, j = i + k - 1; j < nums.length; ) {
            int temp = sum - Math.abs(nums[i - 1]) + nums[j];
            if (temp > sum) {
                sum = temp;
            }
            i++;
            j++;
        }
        System.out.println("sum = " + sum);
        return sum * 1. / k;
    }

}
