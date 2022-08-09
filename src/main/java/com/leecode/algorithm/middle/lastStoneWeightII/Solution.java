package com.leecode.algorithm.middle.lastStoneWeightII;

/**
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class Solution {
    /**
     * 错误写法!
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightIIX(int[] stones) {
        for (int i = 1; i < stones.length; i++) {
            stones[i] = Math.abs(stones[i] - stones[i - 1]);
        }
        return stones[stones.length - 1];
    }

    /**
     * 本质是01背包问题,类似（416. 分割等和子集）
     * 将石头分为正集合与负集合
     * 答案是其中之一的集合的和最接近 (sum / 2)
     * 问题可以转化为
     * 可以将 (sum/2)作为背包大小j
     * stone[0:last]作为维度i
     * if j >=nums[i] then dp[i][j] = Math.max{dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]}
     * if j < nums[i] then dp[i][j] = dp[i-1][j]
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) sum += i;
        int t = sum / 2;
        int[][] f = new int[stones.length + 1][t + 1];
        // i 是从1开始，对应的stone的位置是 i-1
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 0; j <= t; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= stones[i - 1])
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - stones[i - 1]] + stones[i - 1]);
            }
        }
        return Math.abs(sum - f[stones.length][t] - f[stones.length][t]);
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        s.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
    }
}
