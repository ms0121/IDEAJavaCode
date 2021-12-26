package leetcode.string;

/**
 * @author lms
 * @date 2021-10-23 - 18:34
 */
public class L5 {

    public static void main(String[] args) {
        String str = "ababac";
        String res = longestPalindrome(str);
        System.out.println("res = " + res);
    }

    // 暴力解法，超时
    public static String longestPalindrome(String s) {
        String ant = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && max < subStr.length()) {
                    max = subStr.length();
                    ant = subStr;
                }
            }
        }
        return ant;
    }

    private static boolean isPalindrome(String subStr) {
        int len = subStr.length();
        for (int i = 0; i < len / 2; i++) {
            if (subStr.charAt(i) != subStr.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
