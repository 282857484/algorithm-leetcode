package com.leecode.algorithm.easy.invertTree;

import com.leecode.algorithm.node.TreeNode;

import java.util.Stack;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            if (n == null) {
                continue;
            }
            TreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;
            if (n.left !=null) {
                stack.push(n.left);
            }
            if (n.right !=null) {
                stack.push(n.right);
            }
        }
        return root;
    }
}
