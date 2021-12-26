package com.liu.interview;

/**
 * @author lms
 * @date 2021-04-09 - 22:38
 */
public class L_08 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        setZeroes(matrix);
    }

    //    [1,1,1],        [1,0,1],
//    [1,0,1],        [0,0,0],
//    [1,1,1]         [1,0,1]
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 分别记录矩阵中出现0的行和列
        int[] rows = new int[m];
        int[] columns = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
