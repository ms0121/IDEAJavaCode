package com.liu.leetCode;

/**
 * @author lms
 * @date 2021-08-23 - 14:07
 */
public class L_35 {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int index = findIndex(nums, 1);
        System.out.println("index = " + index);
    }

    public static int findIndex(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l == nums.length - 1) {
            return l + 1;
        }
        return l;
    }
}
