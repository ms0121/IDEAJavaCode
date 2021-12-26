package leetcode.array;

import java.util.HashSet;

/**
 * @author lms
 * @date 2021-10-19 - 17:51
 */
public class L26 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int length = removeDuplicates(arr);
        System.out.println("length = " + length);
        HashSet<Integer> set = new HashSet<>();
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums.length;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


}
