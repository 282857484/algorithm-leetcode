package com.leecode.algorithm.middle.coinChange;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Solution {
    /**
     * 完全背包
     * 无序
     * dp[i] 代表背包大小为i的情况下最小的硬币数量
     * dp[i] = min{dp[i], dp[i-coins[j]] + 1}
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 要保证数组不越界并且dp[j - coins[i]]的这个值可达
                if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.coinChange(new int[]{2}, 3);
    }
}
