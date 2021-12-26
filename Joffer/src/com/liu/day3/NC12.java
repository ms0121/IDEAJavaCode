package com.liu.day3;

/**
 * @author lms
 * @date 2021-09-06 - 20:30
 */
public class NC12 {
    public static void main(String[] args) {

    }

    /**
     * 描述
     * 给定某二叉树的前序遍历和中序遍历，请重建出该二叉树并返回它的头结点。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return curTree(pre, vin, 0, 0, pre.length);
    }

    public static TreeNode curTree(int[] pre, int[] vin, int preStart, int vinStart, int len) {
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int k = 0;
        while (pre[preStart] != vin[vinStart + k]) {
            // 找到中间的节点
            k++;
        }
        root.left = curTree(pre, vin, preStart + 1, vinStart, k);
        root.right = curTree(pre, vin, preStart + k + 1, vinStart + k + 1, len - k - 1);
        return root;
    }


}
