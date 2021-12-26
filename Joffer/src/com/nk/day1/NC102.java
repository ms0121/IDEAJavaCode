package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-13 - 9:17
 */
public class NC102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(4);

        root.left = node;
        root.right = node1;
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;

        int ancestor = lowestCommonAncestor(root, 6, 7);
        System.out.println("ancestor = " + ancestor);
    }

    //
    public static int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        TreeNode node = helper(root, o1, o2);
        return node.val;
    }

    public static TreeNode helper(TreeNode root, int o1, int o2){
        // 判断是否是在根节点
        if (root == null || root.val == o1 || root.val == o2){
            return root;
        }
        // 不在根节点,左子树遍历、右子树遍历，知道找到指定的节点
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);

        // 如果左子树为空，说明公共节点在右子树,反之
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        // 如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        //我们只需要返回当前结点即可。
        return root;
    }
}
