package com.liu.day3;

import java.util.*;

/**
 * @author lms
 * @date 2021-07-06 - 15:22
 */
public class NC17 {
    public static void main(String[] args) {
        String str = "abc1234321ab";
        int longestPalindrome = getLongestPalindrome2(str, 12);
        System.out.println(longestPalindrome);
    }


    public static int getLongestPalindrome2(String A, int n) {
        // write code here
        StringBuilder B = new StringBuilder(A).reverse();
        String C = new String(B);
        int[][] arr = new int[A.length() + 1][A.length() + 1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) == C.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else {
                    arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1]);
                }
                if (maxLen < arr[i][j]){
                    maxLen = arr[i][j];
                }
            }
        }
        return maxLen;
    }




    // A = abcd
    public static int getLongestPalindrome(String A, int n) {
        // ba1234321cba
        Stack<Character> stack = getStack(A, n);
        // abc1234321ab
        Queue<Character> queue = getQueue(A, n);
        int count = 0, max = 0;
        while (!stack.isEmpty() && !queue.isEmpty()){
            if ((stack.pop()).equals(queue.poll())){
                count++;
                max = count;
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static Stack<Character> getStack(String str, int n){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(str.charAt(i));
        }
        return stack;
    }

    public static Queue<Character> getQueue(String str, int n){
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(str.charAt(i));
        }
        return queue;
    }
}
