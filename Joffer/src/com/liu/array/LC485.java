package com.liu.array;

/**
 * @author lms
 * @date 2021-03-30 - 23:18
 */
public class LC485 {

    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 1, 1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(arr);
        System.out.println("maxConsecutiveOnes = " + maxConsecutiveOnes);

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                temp++;
//                System.out.println("temp = " + temp);
            }else{
                if (max <= temp){
                    max = temp;
                }
                temp = 0;
            }
        }
        if (max <= temp)
            max = temp;
        return max;
    }
}
