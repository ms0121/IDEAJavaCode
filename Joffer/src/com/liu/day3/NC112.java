package com.liu.day3;


import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * @author lms
 * @date 2021-09-06 - 21:33
 */
public class NC112 {
    public static void main(String[] args) {
        String solve = solve(-4, 3);
        System.out.println("solve = " + solve);
    }

    public static String solve (int M, int N) {
        Object mod;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (M < 0){
            M = -M;
            flag = true;
        }
        while (M != 0){
            mod = M % N;
            if ((int)mod == 10){
                mod = 'A';
            }else if ((int)mod == 11){
                mod = 'B';
            }else if ((int)mod == 12){
                mod = 'C';
            }else if ((int)mod == 13){
                mod = 'D';
            }else if ((int)mod == 14){
                mod = 'E';
            }else if ((int)mod == 15){
                mod = 'F';
            }
            M = M / N;
            sb.append(mod);
        }
        if (flag){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

}
