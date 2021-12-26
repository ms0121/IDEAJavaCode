package com.liu.interview3;

import com.sun.org.glassfish.external.statistics.Statistic;

import java.util.Scanner;

/**
 * @author lms
 * @date 2021-08-08 - 20:46
 */

public class Sushu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        for (int j = 2; j <= num; j++) {
            boolean flag = isFrame(j);
            if (flag){
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    public static boolean isFrame(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
