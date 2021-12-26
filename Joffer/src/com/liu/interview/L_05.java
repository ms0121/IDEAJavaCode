package com.liu.interview;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-04 - 17:45
 */
public class L_05 {
    public static void main(String[] args) {
        String first = "pale";
        String second = "ple";
        boolean flag = oneEditAway(first, second);
        System.out.println("flag = " + flag);
    }

    public static boolean oneEditAway(String first, String second) {
        int length1 = first.length();
        int length2 = second.length();
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;//边界条件，相当于word1的删除操作
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;//边界条件，相当于word1的添加操作
        }
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= length2; j++) {//下面是上面分析的递推公式
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[length1][length2] <= 1;
    }
}
