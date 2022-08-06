package com.leecode.algorithm.easy.isSymmetric;

import com.leecode.algorithm.node.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkTreeNode(root.left,root.right);
    }

    private boolean checkTreeNode(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return checkTreeNode(left.left, right.right) && checkTreeNode(left.right, right.left);
    }
}
