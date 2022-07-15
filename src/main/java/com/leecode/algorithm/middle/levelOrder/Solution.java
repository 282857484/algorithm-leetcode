package com.leecode.algorithm.middle.levelOrder;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
class Solution {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n3.left = n4;
        n3.right = n5;
        List<List<Integer>> xx = s.levelOrder(n1);
        for (List<Integer> x :
                xx) {
            System.out.println("结果:" + x);
        }
        System.out.println("结果:");
    }

    List<List<Integer>> allLevel = new ArrayList<List<Integer>>() {};
    LinkedList<TreeNode> nextlevel = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        nextlevel.add(root);
        visit();
        return allLevel;
    }

    private void visit() {
        LinkedList<Integer> curlist = new LinkedList<>();
        LinkedList<TreeNode> nlist = new LinkedList<>();
        for (TreeNode node : nextlevel) {
            if (node == null) {
                continue;
            }
            curlist.add(node.val);
            if (node.left != null) {
                nlist.add(node.left);
            }
            if (node.right != null) {
                nlist.add(node.right);
            }
        }
        if (curlist.size() > 0) {
            allLevel.add(curlist);
        }
        if (nlist.size() > 0) {
            nextlevel = nlist;
            visit();
        }
    }
}