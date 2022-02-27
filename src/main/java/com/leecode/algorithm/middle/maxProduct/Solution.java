package com.leecode.algorithm.middle.maxProduct;

class Solution {
    public static void main(String[] agrs) {
        Solution s=new Solution();
//        int a = s.maxProduct(new int[]{1,9,-6,9,0,7,1,-1,5,9,-9,9}); // 25515
//        int a = s.maxProduct(new int[]{-4,-3});
        int a = s.maxProduct(new int[]{-2});
        System.out.println(a);
    }
    // 152. 乘积最大子数组
    /**
     * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 测试用例的答案是一个32-位 整数。
     * 子数组 是数组的连续子序列。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        // dpmax[i]的值代表以i为结尾子序列最大乘积
        int[] dpmax = new int[nums.length];
        // dpmin[i]的值代表以i为结尾子序列最小乘积
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // max与min函数可极大简化各种讨论情况，只需把可能的几种情况列出即可
            // 这里不需要讨论正负号，只需要考虑可能性
            // 一种是最大值产生的贡献(最大值变大)，一种是最小值产生的贡献（负数*负数变大，反超最大值）
            // 一种是之前以i为结尾子序列对现在没有贡献（比如i-1位置数值=0，i位置数值>0）
            dpmax[i] = Math.max(dpmax[i-1] * nums[i], Math.max(dpmin[i-1] * nums[i], nums[i]));
            dpmin[i] = Math.min(dpmax[i-1] * nums[i], Math.min(dpmin[i-1] * nums[i], nums[i]));
        }
        for (int i = 0; i < dpmax.length; i++) {
            max = Math.max(max, dpmax[i]);
        }
        return max;
    }
}