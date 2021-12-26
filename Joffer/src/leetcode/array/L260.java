package leetcode.array;

import com.liu.day3.TreeNode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author lms
 * @date 2021-10-30 - 20:47
 */
public class L260 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};
        int[] res = singleNumber(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            res[i++] = integer;
        }
        return res;
    }
}
