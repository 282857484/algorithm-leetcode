package com.leecode.algorithm.node;

import java.util.ArrayList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历、中序遍历、后序遍历
     * @param tree
     */
    private void reverseVisitor(TreeNode tree) {
        // 前序遍历
//        System.out.println(tree.val);
        if (tree.left != null) {
            reverseVisitor(tree.left);
        }
        // 中序遍历
//        System.out.println(tree.val);
        if (tree.right != null) {
            reverseVisitor(tree.right);
        }
        // 后序遍历
        System.out.println(tree.val);
    }
    /**
     * 层序遍历
     * @param tree
     */
    private void reverseVisitorX(TreeNode tree) {

        int cur = 0;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(tree);
        while (cur < list.size()) {
            if (list.get(cur).left != null) {
                list.add(list.get(cur).left);
            }
            if (list.get(cur).right != null) {
                list.add(list.get(cur).right);
            }
            cur ++;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i).val);
        }
    }
}
