package com.liu.interview3;

import com.sun.jndi.toolkit.ctx.StringHeadTail;
import com.sun.org.glassfish.external.statistics.Statistic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lms
 * @date 2021-08-09 - 17:34
 * <p>
 * 求解指定值在数组中的位置下标
 */
public class NumSum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 7, 9};
        int target = 13;
//      int[] index = index(arr, target);
//        int[] index = index2(arr, target);
        int[] index = twoPoint(arr, target);
        System.out.println("Arrays.asList(index) = " + Arrays.toString(index));
    }


    /**
     * 双指针法：只能应用于有序的数组
     * 当两者的和 sum > target, high--, 反之  low ++
     * @param arr
     * @param target
     * @return
     */
    public static int[] twoPoint(int arr[], int target){
        int low = 0, high = arr.length - 1;
        int sum = 0;
        while (low < high){
            sum = arr[low] + arr[high];
            if (sum == target){
                return new int[]{low, high};
            }else if (sum > target){
                high--;
            }else {
                low++;
            }
        }
        return new int[]{0};
    }









    /**
     * 使用map集合的方式进行求解，实现了最多只执行一次遍历就可以找出下标，
     * map: key用于记录已经遍历过的数， value: 记录当前这个key对应的下标i
     * 如果当前  map.containsKey(target - arr[i]) 为true，表示当前的元素可以跟之前
     *      下标为 map.get(target - arr[i])的相加和为target，如果不能，就将已经遍历
     *      过的元素添加到map集合中。
     * @param arr
     * @param target
     * @return
     */
    public static int[] index2(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])){
                return new int[]{map.get(target - arr[i]), i};
            }else {
                map.put(arr[i], i);
            }
        }
        return new int[]{0};
    }

    // 暴力解法
    public static int[] index(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

}
