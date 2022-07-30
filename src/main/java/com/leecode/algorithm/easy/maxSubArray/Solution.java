package com.leecode.algorithm.easy.maxSubArray;

class Solution {
    public static void main(String[] agrs) {
        Solution s=new Solution();
        int a = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(a);
    }
    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *  p[i] = max{ p[i-1] + a[i], a[i]}
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 初始化动态规划数组
        // dp[i]值的含义是以i为结尾的最大子数组和，可以理解为向下贡献值
        int[] dp = new int[nums.length + 1];
        dp[0] = - 999999;
        for (int i = 0; i < nums.length; i++) {
            // 一种情况是，前面的贡献值为无效值（负数）则取当前值为最大值
            // 一种情况是，前面的贡献值为有效值则取当前值为最大值
            dp[i+1] = Math.max(nums[i], nums[i] + dp[i]);
            max = Math.max(max, dp[i+1]);
        }
        return max;
    }
}