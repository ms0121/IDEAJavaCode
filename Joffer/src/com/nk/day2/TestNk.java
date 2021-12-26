package com.nk.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author lms
 * @date 2021-10-06 - 11:35
 */
public class TestNk {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
    }

    // NC88: 寻最第 K 大的元素
    // {1,3,5,2,2}  5  3 ==> 最后堆排序为  2 3 5
    public static int findKth(int[] a, int n, int K) {
        // 默认使用的是小根堆，堆顶元素是最小的(比堆顶元素大的都放在堆下面)
        // 寻找的是第几大，name就创建多大的小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(K);
        for (int i = 0; i < n; i++) {
            if (queue.size() < K){
                queue.add(a[i]);
            }else {
                if (a[i] > queue.peek()){
                    queue.poll();
                    queue.add(a[i]);
                }
            }
        }
        return queue.peek();
    }


    //NC15: 使用层次遍历的方式
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            // 记录每一层的节点数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                subList.add(node.val);
            }
            result.add(subList);
        }
        return result;
    }

}
