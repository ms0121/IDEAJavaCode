package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author lms
 * @date 2021-11-01 - 20:49
 */
public class L575 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int candies = distributeCandies(arr);
        System.out.println(candies);
    }

    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
