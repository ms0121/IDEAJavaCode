package com.liu.day5;

/**
 * @author lms
 * @date 2021-08-28 - 21:30
 */
public class NC_107 {
    public static void main(String[] args) {
        int a[] = {2, 4, 1, 2, 7, 8, 4};
        int solve = solve(a);
        System.out.println("solve = " + solve);
    }

    public static int solve(int[] a) {
        int n = a.length - 1;
        int i = n - 1;
        for (; i >= 0; i--) {
            if ((i+1 == n || a[i] >= a[i+1]) &&(i-1 == 0 || a[i] >= a[i-1])){
                return i;
            }
        }
        return -1;
    }
}
