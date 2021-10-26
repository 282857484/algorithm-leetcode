package com.leecode.algorithm.hard.treeMaxPathSum;

/**
 *     public class TreeNode {
 *         int val;
 *         TreeNode left;
 *         TreeNode right;
 *         TreeNode() {}
 *         TreeNode(int val) {
 *             this.val = val;
 *         }
 *         TreeNode(int val, TreeNode left, TreeNode right) {
 *             this.val = val;
 *             this.left = left;
 *             this.right = right;
 *         }
 *     }
 */
class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n3.left = n4;
        n3.right = n5;

//        System.out.println("结果:" + s.maxPathSum(n1));
        TreeNode n6 = new TreeNode(-3);
        System.out.println("结果:" + s.maxPathSum(n6));
    }


    public int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxUpPath(root);
        return maxPath;
    }

    /**
     *
     * @param node
     * @return 以node为终点最大上升路径之和
     */
    public int maxUpPath(TreeNode node) {
        int leftUp = 0;
        int rightUp = 0;
        if (node.left != null){
            leftUp = Math.max(maxUpPath(node.left), 0);
        }
        if (node.right != null) {
            rightUp = Math.max(maxUpPath(node.right), 0);
        }
        maxPath = Math.max((leftUp + rightUp + node.val), maxPath);
        return Math.max(leftUp+ node.val, rightUp+ node.val);
    }

}