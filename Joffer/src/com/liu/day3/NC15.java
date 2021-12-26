package com.liu.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-07-04 - 14:06
 */
public class NC15 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        List list = LevelOrder(root);
        System.out.println("list = " + list);
    }

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static List LevelOrder(TreeNode root){
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null){
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            ArrayList<Integer> subList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.get(0);
                subList.add(temp.val);
                queue.remove(0);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
