package com.liu.interview;

import com.sun.prism.ReadbackRenderTarget;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author lms
 * @date 2021-04-10 - 9:02
 */
public class L_12 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode1.right = treeNode4;
        treeNode.right = treeNode2;

        int i = maxDepth(treeNode);
        System.out.println("i = " + i);

    }

    // 计算二叉树的高度
    //    1、如果一棵树只有一个节点，那么它的深度为1。
    //    2、如果根节点只有左子树而没有右子树，那么树的深度应该是其左子树的深度加1；
    //    3、同样，如果根节点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1；
    //    4、如果既有右子树又有左子树，那么该树的深度就是其左、右子树深度的较大值再加1；
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? (l + 1) : (r + 1);
    }
}
