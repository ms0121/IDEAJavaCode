package com.nk.day1;

import org.omg.CORBA.IRObjectOperations;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * @author lms
 * @date 2021-10-30 - 19:53
 */
public class NC6 {
    public static void main(String[] args) {

    }

    // 顶一个全局变量，用于保存二叉树中的最大值
    public int MAX_VALUE = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
//        maxGain(root);
        maxLength(root);
        return MAX_VALUE;
    }


    /**
     * 四种情况：
     *  1.如果root节点为空   0
     *  2.如果右子节点小于0.只保留左子节点，
     *  3.如果左子节点小于0.只保留右子节点，
     *  4.左右子节点都打于0，二者都要进行保留
     * @param root
     * @return
     */
    public int maxLength(TreeNode root){
        if (root == null){
            return 0;
        }
        // 计算左右两边节点的最大值
        int left = maxLength(root.left);
        int right = maxLength(root.right);
        // 两个节点都保留
        int cur = root.val + Math.max(0, left) + Math.max(0, right);
        // 保留其中的一个节点
        int res = root.val + Math.max(0, Math.max(left, right));
        // 记录最大值
        MAX_VALUE = Math.max(MAX_VALUE, Math.max(cur, res));
        //
        return res;
    }

    /**
     * 循环计算每个子树当中的最大值
     * @param root
     * @return
     */
    public int maxGain(TreeNode root){
        // 如果是空树直接返回0
        if (root == null){
            return 0;
        }
        // 求root节点的左右子树的最大值
        int leftMax = Math.max(maxGain(root.left), 0);
        int rightMax = Math.max(maxGain(root.right), 0);

        // 记录当前子树构成的最大值
        int price = root.val + leftMax + rightMax;
        // 记录整棵二叉树的最大值
        MAX_VALUE = Math.max(price, MAX_VALUE);

        // 返回最大节点的贡献值
        return root.val + Math.max(leftMax, rightMax);
    }


}
