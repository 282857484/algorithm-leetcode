package com.leecode.algorithm.middle.canJump;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:" + s.canJump(new int[]{0,1}));
    }
    public boolean canJump(int[] nums) {
        // 目标是最后一个元素的下标
        int target = nums.length-1;
        // 最远能达到nums的位置
        int[] dp = new int[nums.length+1];
        // 代表nums的位置0是可达的
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            // dp[i]代表i之前最远可达位置，nums[i]+i代表i位置最远可达位置
            dp[i+1] = Math.max(dp[i], nums[i] + i);
            if (dp[i+1] >= target) {
                return true;
            }
            // 如果下一跳不可达则不可达最后一个元素
            if (dp[i+1] < (i+1)) {
                break;
            }
        }
        return false;
    }
}