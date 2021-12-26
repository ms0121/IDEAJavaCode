package com.liu.interview3;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-08-08 - 22:07
 */
public class PivotIndex {
    public static void main(String[] args) {
        int arr[] = {1, 3, 7, 6, 5, 6};
        int pivot = pivot(arr);
        System.out.println("pivot = " + pivot);
    }

    /**
     * 计算数组的中心下标：中心下标指的是左右两边的值相等，说明当前的节点为中心节点，对应的下标即为中心下标
     * 计算方式：先计算总数sum(从左至右进行递减)，然后设置一个从左向右记录的total，中心节点被重叠计算
     * @param arr
     * @return
     */
    public static int pivot(int arr[]) {
        int sum = Arrays.stream(arr).sum();
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            // 如果相等说明是中心坐标，否则继续往后计算
            if (total == sum){
                return i;
            }
            sum -= arr[i];
        }
        return -1;
    }

}
