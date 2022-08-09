package com.leecode.algorithm.middle.canPartition;

import java.util.Arrays;
import java.util.LinkedList;

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
class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:" + s.canPartition(new int[]{2,2,3,5}));
    }

    /**
     * 分析
     * 为什么不用DFS深度搜索，这个元素存在或者不存在是两种状态，所以搜索的时间复杂度过高 n * 2^n
     * 0-1背包问题，将上一个状态转移到新状态中，从而缩减问题规模
     * 判断i位置target的可达性，依赖更小区间能达到位置
     * dp[i][j] 代表[0, i]区间里是否有子集之和等于j
     * 如果等于j那么dp[i][j]为true，否则为false
     * 终点target为sum/2
     * 如果dp[i][j]中j==target说明存在子集和为sum/2
     * i 相对于 i-1 而言，一种是 j 在 i-1 时就可达，一种是 i-1 在 j-nums[i] 可达
     * 状态转移方程可以写为：
     * dp[i][j] = dp[i-1][j] or dp[i-1][j - nums[i]]
     * j-nums[i] 如果是负数，那么不在我们的查表范围会报数组越界
     * 所以 j - nums[i] 如果小于0 ，则为False
     * j - nums[i] 如果小于0，则状态转移方程变为：
     * dp[i][j] = dp[i-1][j]
     *
     * 经分析我们只要分析每层的可达性，将二维数组转为一维数组即可
     * dp[j] 表示j位置的可达性，从第一个元素开始循环n轮更新dp即可
     * 这样减少了空间复杂度
     *
     * 执行用时: 51 ms
     * 内存消耗: 38.5 MB
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 奇数直接返回，不可能有这样的子集
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum/2;
        // 下标从0开始，dp[target] == True 则成功
        boolean[] dp = new boolean[target + 1];
        LinkedList<Integer> forUpdate = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 更新dp表
            for (int j = 1; j < dp.length; j++) {
                if (dp[j]) {
                    if (j+ nums[i] <= target) {
                        forUpdate.add(j + nums[i]);
                    }
                }
            }
            if (nums[i] <= target) {
                // i位置的值必定可达
                dp[nums[i]] = true;
            }
            for (int u:forUpdate) {
                dp[u] = true;
            }
            forUpdate.clear();

            if (dp[target]){
                return true;
            }
        }
        return false;
    }

}