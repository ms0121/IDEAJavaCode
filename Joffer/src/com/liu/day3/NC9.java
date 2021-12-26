package com.liu.day3;

/**
 * @author lms
 * @date 2021-09-09 - 20:38
 */
public class NC9 {
    public static void main(String[] args) {

    }

    public static boolean hasPathSum (TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        // 只有叶子结点的值等于sum，才说明是一个路径
        if (root.left == null && root.right == null && root.val == sum){
            return true;
        }
        // 否则，向下递归计算
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
