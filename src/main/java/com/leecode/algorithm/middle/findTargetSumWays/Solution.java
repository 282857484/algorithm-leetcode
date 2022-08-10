package com.leecode.algorithm.middle.findTargetSumWays;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 */
public class Solution {
    /**
     * 01背包，需要把正数负数都填表
     * dp[i][j] 代表[0:i]个元素，相加的值等于j的个数
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i]);
        }
        int zeroJ = sum;
        if (sum < target) {
            return 0;
        }
        int[][] dp = new int[nums.length][sum*2+1];

        // 初始化第一行
        dp[0][zeroJ-nums[0]] = 1;
        dp[0][zeroJ+nums[0]] = dp[0][zeroJ+nums[0]]+ 1;
        // 依次算出二位数组每个位置的值
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < (sum * 2 + 1); j++) {
                if ((j+nums[i]) >= (sum * 2 + 1)){
                    dp[i][j] = dp[i-1][j-nums[i]];
                } else if ((j-nums[i]) < 0) {
                    dp[i][j] = dp[i-1][j+nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[nums.length-1][zeroJ+target];
    }
    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1));
//        s.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1);
    }
}
