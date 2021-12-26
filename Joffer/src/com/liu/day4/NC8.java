package com.liu.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-08-22 - 18:47
 */

public class NC8 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.left = node1;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;

        root.right = node2;
        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;

        ArrayList<ArrayList<Integer>> arrayLists = pathSum(root, 22);


    }


    public static ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> result= new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    /**
     * 从上往下进行遍历
     * @param root
     * @param sum
     * @param list
     * @param result
     */
    public static void dfs(TreeNode root, int sum, List<Integer> list,
                    List<ArrayList<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
            return;
        //因为list是引用传递，为了防止递归的时候分支污染，我们要在每个路径
        //中都要新建一个subList
        ArrayList<Integer> subList = new ArrayList<>(list);
        //把当前节点值加入到subList中
        subList.add(root.val);
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null) {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.val)
                result.add(subList);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, subList, result);
        dfs(root.right, sum - root.val, subList, result);
    }
}
