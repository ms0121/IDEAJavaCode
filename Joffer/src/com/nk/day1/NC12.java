package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-14 - 17:39
 */
public class NC12 {
    public static void main(String[] args) {

    }

    // 重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        return curTree(pre, vin, 0, 0, pre.length);
    }



    /**
     * 使用先序、中序重建二叉树
     * @param pre      前半部分数组
     * @param vin      后半部分数组
     * @param preStart 先序数组的下标
     * @param vinStart 中序数组的下标
     * @param len
     * @return
     */
    public static TreeNode curTree(int[] pre, int[] vin, int preStart, int vinStart, int len) {
        if (len == 0) {
            return null;
        }
        // 每个子树的根节点
        TreeNode root = new TreeNode(pre[preStart]);
        int k = 0;
        // 找到先序数组的分割点
        while (pre[preStart] != vin[vinStart + k]) {
            // 找到中间的节点
            k++;
        }
        // 构建左子树
        root.left = curTree(pre, vin, preStart + 1, vinStart, k);
        // 构建右子树,
        root.right = curTree(pre, vin, preStart + k + 1, vinStart + k + 1, len - k - 1);
        return root;
    }


    /**
     * 使用先序，中序重建当前的二叉树
     * @param pre
     * @param vin
     * @param preStart
     * @param vinStart
     * @param len
     * @return
     */
    public static TreeNode curTree2(int[] pre, int[] vin, int preStart, int vinStart, int len){
        if (len == 0){
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(pre[preStart]);
        int k = 0;
        // 找到中序的分割点
        while (pre[preStart] != vin[vinStart + k]){
            k++;
        }
        // 左边进行构建二叉树
        root.left = curTree2(pre, vin, preStart + 1, vinStart, k);
        // 右边进行构建二叉树
        root.right = curTree2(pre, vin, preStart + k + 1, vinStart + k + 1, len - k - 1);
        return root;
    }
}
