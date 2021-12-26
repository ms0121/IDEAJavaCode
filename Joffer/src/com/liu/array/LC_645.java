package com.liu.array;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-04-02 - 21:50
 */
public class LC_645 {
    public static void main(String[] args) {
        int[] arr = {2, 2};
        int[] errorNums = findErrorNums(arr);
        for (int i = 0; i < errorNums.length; i++) {
            System.out.println("errorNums[i] = " + errorNums[i]);
        }
    }

    public static int[] findErrorNums(int[] nums) {
        int p = -1, q = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2){
                p = i;
            }else if (count == 0){
                q = i;
            }
            if (p > 0 && q > 0){
                break;
            }
        }
        return new int[]{p, q};
    }
}
