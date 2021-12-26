package com.liu.interview2;

import java.util.HashSet;

/**
 * @author lms
 * @date 2021-07-02 - 23:58
 */
public class L0201 {
    public static void main(String[] args) {
        int nums[] = {2,3,2,4,3};
        int i = maxLength(nums);
        System.out.println("i = " + i);
//        int target = -2;
//        int search = search(nums, target);
//        System.out.println("search = " + search);


    }

    public static int search (int[] nums, int target) {
        int low = 0, high = nums.length, mid=0;
        if (high == 0){
            return -1;
        }
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                break;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(low > high){
            return -1;
        }
        if (mid == 0){
            return mid;
        }
        int x = mid - 1;
        while(x >= 0 && nums[x] == nums[mid]){
            mid = x;
            x--;
        }
        return mid;
    }

    public static int maxLength (int[] arr) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set.size();
    }

}
