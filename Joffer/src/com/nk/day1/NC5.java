package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-22 - 22:48
 */
public class NC5 {
    public static void main(String[] args) {

    }

    public int sumNumbers (TreeNode root) {
        int sum = sum(root, 0);
        return sum;
    }

    public static int sum(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        // 记录上一层到当前层的值
        sum = sum * 10 + root.val;
        // 判断是否为叶子结点
        if (root.left == null && root.right == null){
            return sum;
        }
        return sum(root.left, sum) + sum(root.right, sum);
    }
}
