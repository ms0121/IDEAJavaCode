package com.liu.day3;

/**
 * @author lms
 * @date 2021-08-11 - 21:59
 */
public class NC105 {
    public static void main(String[] args) {
        int arr[] = {-2, 1, 2};
        int search = search(arr, -2);
        System.out.println("search = " + search);
    }

    public static int search(int[] nums, int target) {
        // write code here
        int low = 0, high = nums.length - 1, mid = 1;
        boolean flag = false;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                flag = true;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!flag){
            return -1;
        }

        while ((mid-1) >= 0 && (nums[mid - 1] == target)) {
            mid--;
        }
        return mid;
    }
}
