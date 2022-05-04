package com.leecode.algorithm.hard.candy;

/**
 * 135. 分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 示例1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.candy(new int[]{1,2,3,3,3,2,1});
    }
    /**
     * 规则
     * 1、每个孩子一个糖果（每个人先分一个）
     * 2、相邻两个孩子评分更高的孩子会获得更多的糖果（从左到右比较，再从右到左比较）
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] child = new int[ratings.length];
        for (int i = 0; i < child.length; i++) {
            child[i] = 1;
        }
        for (int i = child.length-1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]
                    && child[i-1] <= child[i]) {
                child[i-1] = child[i] + 1;
            }
        }
        for (int i = 0; i < child.length-1; i++) {
            if (ratings[i+1] > ratings[i]
                    && child[i+1] <= child[i]) {
                child[i+1] = child[i] + 1;
            }
        }
        int numCandy = 0;
        for (int i = 0; i < child.length; i++) {
            numCandy += child[i];
        }
        return numCandy;
    }
}
