package com.liu.day3;

/**
 * @author lms
 * @date 2021-09-09 - 19:38
 */
public class NC101 {
    public static void main(String[] args) {
        int a[] = {0,2,3};
        int solve = solve(a);
        System.out.println("solve = " + solve);
    }

    public static int solve (int[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            if (i != a[i]){
                return i;
            }
        }
        return i+1;
    }
}
