package com.nk.day2;

/**
 * @author lms
 * @date 2021-09-15 - 13:40
 */
public class NC60 {
    public static void main(String[] args) {

    }

    // 判断给定的二叉树是否是二叉搜索树和完全二叉树
    public static boolean[] judgeIt (TreeNode root) {
        // write code here
        return new boolean[]{true, true};
    }

    // 判断二叉搜索树
    public static boolean isSearchTree(TreeNode root){
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        if (root.left.val < root.val && root.right == null){
            return true;
        }
        if (root.right.val > root.val && root.left == null){
            return true;
        }
        if (root.left.val < root.val && root.right.val > root.val){
            return true;
        }

        return false;
    }
}
