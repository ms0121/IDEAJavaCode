package com.liu.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lms
 * @date 2021-04-02 - 23:11
 */
public class L_04 {
    public static void main(String[] args) {
        String str = "tactcoac";
        boolean flag = canPermutePalindrome(str);
        System.out.println("flag = " + flag);
    }

    public static boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char ch: s.toCharArray()){
            //set的add方法如果返回false，表示已经有了，如果没有就会返回true，表示添加成功
            //我们就把他删除
            if (!set.add(ch)){
                set.remove(ch);
            }
        }
//        /最后判断set的长度是否小于等于1，如果等于1说明
//        //只有一个字符的个数是奇数，其他的都是偶数。如果
//        //等于0说明每个字符都是偶数，否则不可能构成回文字符串
        if (set.size() <= 1){
            return true;
        }else {
            return false;
        }
    }
}
