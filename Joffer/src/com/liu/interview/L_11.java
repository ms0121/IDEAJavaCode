package com.liu.interview;

import javafx.scene.transform.Rotate;
import org.omg.CORBA.INTERNAL;
import sun.awt.image.IntegerInterleavedRaster;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-10 - 8:21
 */
public class L_11 {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode1.right = treeNode4;
        treeNode.right = treeNode2;
        int i = kthLargest(treeNode, 0);
        System.out.println("i = " + i);
    }

    public static int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> list1 = getList(root, list);
        return list1.get(list1.size() - k);
    }

    // 中序遍历二叉搜索树是从小到大排序
    public static List<Integer> getList(TreeNode root, List<Integer> list){
        if (root != null){
            getList(root.left, list);
            list.add(root.val);
            getList(root.right, list);
        }
        return list;
    }



//    public static int kthLargest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list1 = getList(root, list);
//        Collections.sort(list1);
////        System.out.println();
//        return list1.get(list1.size()-1);
//
//    }
//
//
//    public static List<Integer> getList(TreeNode root, List<Integer> list){
//        if (root != null){
//            list.add(root.val);
//            getList(root.left, list);
//            getList(root.right, list);
//        }
//        return list;
//    }
}
