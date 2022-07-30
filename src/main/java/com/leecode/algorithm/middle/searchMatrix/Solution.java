package com.leecode.algorithm.middle.searchMatrix;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索m * n矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 */

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(s.searchMatrix(m, 5));
    }


    // 不要用dfs 时间复杂度 O(m*n)

    /**
     * 为什么选择右上角作为起始点？因为这样只有左移和下移操作
     * 因为如果存在相等的值会在分界线上，所以顺着分界线查询就能知道是否存在了，并且不需要拐弯
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while (row < m && col >=0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


}
