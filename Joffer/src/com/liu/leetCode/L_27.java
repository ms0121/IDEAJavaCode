package com.liu.leetCode;

/**
 * @author lms
 * @date 2021-08-22 - 23:04
 */
public class L_27 {
    public static void main(String[] args) {
        int[] array = {3,2,2,3}; // {0,1,4,0,3}
//        int[] array = {1, 2, 2, 1};
        int num = remove(array, 3);
        System.out.println("num = " + num);
    }

    /**
     * 移除数组中所有的target值的元素，只能使用O(1)的存储空间，最终返回数组移除后的数组长度
     *
     * @param arr
     * @param target
     * @return
     */
    public static int remove(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            // 从左往右找到为target的值
            while (arr[l] != target) {
                l++;
            }
            // 从右往左找到不等于target的元素
            while (arr[r] == target) {
                r--;
            }
            // 将两边的值进行交换
            arr[l] = arr[r];
            arr[r] = target;
        }
        return l;
    }
}
