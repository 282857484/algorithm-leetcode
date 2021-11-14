package com.leecode.algorithm.middle.canPartition;

import java.util.Arrays;
import java.util.LinkedList;

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

    /**
     * 贪心？
     * 只执行了1ms！
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums)
    {
        Arrays.sort(nums);
        int first = 0;
        int second = 0;
        int maxIndex = nums.length - 1;
        for (int i = maxIndex; i >= 0; i --)
        {
            if (first < second)
            {
                first += nums[i];
            }
            else
            {
                second += nums[i];
            }
        }
        if (first == second)
        {
            return true;
        }

        int sum = first + second;
        int halfSum = sum >> 1;
        if ((sum & 1) == 1 || nums[maxIndex] > halfSum)
        {
            return false;
        }

        first = second = halfSum;
        for (int i = maxIndex; i >= 0; i--)
        {
            if (first >= nums[i])
            {
                first -= nums[i];
            }
            else
            {
                second -= nums[i];
            }
        }
        return first == second;
    }
}