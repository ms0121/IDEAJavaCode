package leetcode.array;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-10-24 - 8:58
 */
public class L132 {

    public static void main(String[] args) {
        int[] arr = {-1,3,2,0};
        boolean pattern = find132pattern2(arr);
        System.out.println("pattern = " + pattern);
    }

    public static boolean find132pattern2(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return false;
        }
        // 元素的下标
        int k = -1;
        Stack<Integer> stack = new Stack<>();
        // 从后往前进行遍历整个数组
        for (int i = len - 1; i >= 0; i--) {
            // 判断k指向的元素是否大于最小的元素j（i）
            if (k > -1 && nums[k] > nums[i]) return true;
            // 判断中间值
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                k = stack.pop();
            }
            stack.push(i);
        }
        return false;
    }















    public static boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[i] < nums[j] && nums[k] < nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
