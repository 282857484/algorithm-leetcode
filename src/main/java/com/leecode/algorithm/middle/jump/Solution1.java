package com.leecode.algorithm.middle.jump;

/**
 * 跳跃游戏2
 * 动态规划 312ms
 */
class Solution1 {
    // 性能很差，建议用贪心算法
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((j + nums[j]) >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length-1];
    }
}
