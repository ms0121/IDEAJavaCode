package com.liu.day3;

/**
 * @author lms
 * @date 2021-07-05 - 11:55
 */
public class NC55 {
    public static void main(String[] args) {
        String strs[] = {"abca","abc","abca","abc","abcc"};
        String s = longestCommonPrefix(strs);
        System.out.println("s = " + s);
    }

    public static String longestCommonPrefix (String[] strs) {
        int min = 0;
        String minStr = "";
        for (String str : strs) {
            if (str.isEmpty()){
                return null;
            }
            if (str.length() > min){
                min = str.length();
                minStr = str;
            }
        }
        int k = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < minStr.length(); j++) {
            for (int i = 0; i < strs.length; i++) {
                if (minStr.charAt(k) != strs[i].charAt(k)){
                    flag = false;
                }
            }
            if (flag = true){
                sb.append(minStr.charAt(k));
                k++;
            }else {
                break;
            }
        }
        System.out.println("sb = " + sb);
        return null;
    }
}
