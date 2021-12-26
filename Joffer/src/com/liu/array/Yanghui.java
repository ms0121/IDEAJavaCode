package com.liu.array;

/**
 * @author lms
 * @date 2021-08-28 - 14:34
 */
public class Yanghui {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++)
        {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }

        for (int i = 2; i < arr.length; i++)
        {
            /* code */
            for (int j = 1; j < i; j++)
            {
                /* code */
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
