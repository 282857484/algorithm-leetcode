package com.leecode.algorithm.easy.maxDepth;

import com.leecode.algorithm.node.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        return bfs(root, 1);
        return dfs(root);
    }

    // 也可以用栈遍历
    private int dfs(TreeNode root, int n) {
        int result = n;
        if (root.left != null) {
            result = Math.max(result,dfs(root.left, n+1));
        }
        if (root.right != null) {
            result = Math.max(result,dfs(root.right, n+1));
        }
        return result;
    }

    private int dfs(TreeNode node) {
        int l = 0;
        if (node.left != null) {
            l = dfs(node.left) + 1;
        }
        int r = 0;
        if (node.right != null) {
            r = dfs(node.right) + 1;
        }
        return Math.max(l, r);
    }

}
