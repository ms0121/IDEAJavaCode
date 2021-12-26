package com.liu.interview;

import java.rmi.MarshalException;
import java.util.Arrays;

/**
 * @author lms
 * @date 2021-04-05 - 8:39
 */
public class L_07 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{5, 1, 9,11},
//                          { 2, 4, 8,10},
//                          {13, 3, 6, 7},
//                          {15,14,12,16}};
        rotate(matrix);
    }

    // 实现矩阵的90度翻转
    public static void rotate(int[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int k = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {
                arr[i][k] = matrix[j][i];
                k++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("[");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
