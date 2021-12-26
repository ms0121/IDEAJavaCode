package com.liu.day4;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-19 - 21:46
 */
public class NC92 {
    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        int lcs = LCS(s1, s2);
        System.out.println("lcs = " + lcs);
    }

    /**
     * 计算最长公共子序列：
     *   计算公式: 如果两个字符相等，则当前target[i][j] = target[i-1][j-1] + 1
     *            否则就等于: target[i][j] = Math.max(target[i-1][j], target[i][j-1]);
     * @param s1
     * @param s2
     * @return
     */
    public static int LCS (String s1, String s2) {
        // write code here
        int row = s1.length() + 1, col = s2.length() + 1;
        Queue<Character> queue = new LinkedList<>();
        int[][] target = new int[row][col];
        for (int i = 0; i < target[0].length; i++) {
            target[i][0] = 0;
        }
        for (int i = 0; i < target.length; i++) {
            target[0][i] = 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    target[i][j] = target[i-1][j-1] + 1;
                    queue.offer(s1.charAt(i-1));
                }else {
                    target[i][j] = Math.max(target[i-1][j], target[i][j-1]);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()){
            builder.append(queue.poll());
        }
        String s = new String(builder);
        return target[row-1][col-1];
    }

}
