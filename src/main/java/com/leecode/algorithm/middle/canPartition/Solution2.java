package com.leecode.algorithm.middle.canPartition;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class Solution2 {
    /**
     * NP问题
     * 01背包变形，存在或者不存在这是一个问题
     * 特征是暴力求解时间复杂度2^n
     * 一般是通过动态规划求解
     *
     *
     * 总和需要满足是一个偶数，如果是奇数的话肯定不满足
     * target是数组的总和的一半，即j最大为target
     *
     * dp[i][j] 代表[0:i)这个区间的值在背包大小为j的情况下，如果能正好装满j大小的包，则为true
     * true即为可达性，否则为false即不满足
     * if j < nums[i] then dp[i][j] = dp[i-1][j]
     * if j >= nums[i] then dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j]
     * 初始条件dp[i][0]代表的含义是背包大小为0，一个元素都没有的情况可以满足，这个情况无论几个元素都可以满足
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // 初始化 （dp可以优化为一维数组）
        boolean[][] dp = new boolean[nums.length][target+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
