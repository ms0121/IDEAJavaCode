package com.liu.day3;

/**
 * @author lms
 * @date 2021-09-09 - 19:47
 */
public class NC16 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric (TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root.left, root.right);
    }
    public static boolean check(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 != null || root2 != null){
            return false;
        }
        return (root1.val == root2.val) && check(root1.left, root2.right) && check(root1.right, root2.left);
    }

}
