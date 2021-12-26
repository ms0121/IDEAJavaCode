package com.nk.day2;

/**
 * @author lms
 * @date 2021-09-15 - 10:56
 */
public class NC5 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        root.left = node;
        root.right = node1;
        node.right = node2;
        node1.left = node3;

        int numbers = sumNumbers(root);
        System.out.println("numbers = " + numbers);

    }

    // 路径和
    public static int sumNumbers (TreeNode root){
        int sum = sum(root, 0);
        return sum;
    }

    /**
     * @param root
     * @param sum 上一层的值
     * @return
     */
    public static int sum(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
        // 计算从上到当前节点的值
        sum = sum * 10 + root.val;
        // 当前的这一条路径到达叶子结点
        if (root.left == null && root.right == null){
            return sum;
        }
        // 从当前节点开始递归计算当前节点的左右子树，并把当前层的累计值传到下一层
        return sum(root.left, sum) + sum(root.right, sum);
    }
}
