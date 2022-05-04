package com.leecode.algorithm.easy.diameterOfBinaryTree;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.TreeNode;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.diameterOfBinaryTree(CreateStruct.createTreeByArray(new int[]{1, 2, 3, 4, 5}));
    }
    int maxDep = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDep;
    }

    private int dfs(TreeNode node) {
        int leftDep = 0;
        if (node.left != null) {
            leftDep = dfs(node.left) + 1;
        }
        int rightDep = 0;
        if (node.right != null) {
            rightDep = dfs(node.right) + 1;
        }
        maxDep = Math.max(maxDep, leftDep + rightDep);
        return Math.max(leftDep, rightDep);
    }
}
