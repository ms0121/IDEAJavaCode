package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-09 - 21:59
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        int methods = methods(11);  // 1 2 3 4
        System.out.println("methods = " + methods);
    }

    // 根据硬币的个数进行排列，第k行有k个硬币，返回填满的行数
    // 把i看成是每第i行的理应当拥有的硬币个数，n为除去上一行剩下的硬币数
    public static int methods(int n){
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n <= i){
                return i;
            }
        }
        return -1;
    }
}
