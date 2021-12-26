package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-14 - 17:15
 */
public class NC32 {
    public static void main(String[] args) {

    }

    public int sqrt (int x) {

        for (int i = 1; i < x; i++) {
            if (i * i < x && (i+1)*(i+1) > x){
                return i;
            }
        }
        return -1;
    }
}
