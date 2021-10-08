package com.leecode.algorithm.middle.lengthOfLIS;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // 初始化dp
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        // 从小问题开始解决并记录，一步一步推导大问题
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        int maxlength = 0;
        for (int i = 0; i< dp.length;i++) {
            maxlength = Math.max(maxlength, dp[i]);
        }
        return maxlength;
    }
}
