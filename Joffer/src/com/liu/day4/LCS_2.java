package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-25 - 11:35
 */
/**
 * 最长公共子串
 * 子串相对于子序列，最大的区别是要求连续的
 * 这里的arr数组保存的是以a[i]和b[j]为结尾的公共子字符串的长度
 * 之所以存储这种情况，是因为计算简单
 * 但是获取最大值的话还需要一次遍历
 * 也可以把最后需要的结果直接用变量的方式存起来，都是ok的
 */
public class LCS_2 {

    public static void main(String[] args) {
        String a = "hwmrold";
        String b = "orlmro";
        lcs(a, b);
    }

    private static void lcs(String a, String b) {
        if (a == null || b == null) {
            return;
        }
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int lengthA = charA.length;
        int lengthB = charB.length;

        int[][] arr = new int[lengthA + 1][lengthB + 1];
        // 对二维数组 arr 进行填表的操作，从第二行第二列开始填表
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (charA[i - 1] == charB[j - 1]) {
                    // 建表的过程
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
            }
        }

        int maxLength = 0;
        int end = 0;
        // 遍历二维数组
        for (int i = 0; i <= lengthA; i ++) {
            for (int j = 0; j <= lengthB; j++) {
                // 找出公共子串的最大值
                if (maxLength < arr[i][j]) {
                    end = i;
                    maxLength = arr[i][j];
                }
            }
        }
        System.out.println("end = " + end);
        System.out.println("最大长度为:" + maxLength);
        System.out.println("字符串为:" + a.subSequence(end - maxLength, end));
    }
}
