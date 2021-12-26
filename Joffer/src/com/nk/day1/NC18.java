package com.nk.day1;

/**
 * @author lms
 * @date 2021-11-07 - 14:44
 */
public class NC18 {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = rotateMatrix(arr, 3);
    }

    public static int[][] rotateMatrix(int[][] mat, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-i-1] = mat[i][j];
            }
        }
        return res;
    }
}
