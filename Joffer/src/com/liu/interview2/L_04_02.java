package com.liu.interview2;

/**
 * @author lms
 * @date 2021-04-23 - 23:06
 */
public class L_04_02 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(20);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        boolean validBST = isValidBST(treeNode);
        System.out.println("validBST = " + validBST);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                if (root.left.val <= root.val && root.right.val >= root.val) {
                    return true;
                } else {
                    return false;
                }
            } else if (root.left == null && root.right == null) {
                return true;
            } else if (root.left != null) {
                if (root.left.val <= root.val) {
                    return true;
                } else {
                    return false;
                }
            } else if (root.right != null) {
                if (root.right.val >= root.val) {
                    return true;
                } else {
                    return false;
                }
            }
            if (root.left != null) {
                isValidBST(root.left);
            }
            if (root.right != null) {
                isValidBST(root.right);
            }
        }
        return true;
    }


}
