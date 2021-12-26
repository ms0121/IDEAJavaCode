package com.data.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-10-16 - 12:16
 */
public class L118 {
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(5);
        System.out.println(lists);

        Stack<Integer> stack = new Stack<>();
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] yh = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            yh[i][0] = 1;
            yh[i][i] = 1;
        }
        for(int i=1;i<numRows;i++){
            for(int j=1;j<numRows;j++){
                yh[i][j] = yh[i-1][j] + yh[i-1][j-1];
            }
        }
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> sublist = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                sublist.add(yh[i][j]);
            }
            result.add(sublist);
        }
        return result;
    }
}
