package com.leecode.algorithm.middle.integerBreak;

/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 */
public class Solution {
    /**
     * 方法一：动态规划
     * 对于的正整数 n，当 n >=2 时，可以拆分成至少两个正整数的和。
     * 令 k是拆分出的第一个正整数，则剩下的部分是 n-k，n-k可以不继续拆分，或者继续拆分成至少两个正整数的和。
     * 由于每个正整数对应的最大乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
     *
     * 创建数组 dp，其中dp[i] 表示将正整数 i拆分成至少两个正整数的和之后，这些正整数的最大乘积。
     * 特别地，0 不是正整数，1是最小的正整数，0和 1都不能拆分。
     *
     * 当 i>=2 时，假设对正整数 i拆分出的第一个正整数是j(1<j<i)，则有以下两种方案：
     * 将 i拆分成 j和 i-j的和，且 i-j不再拆分成多个正整数，此时的乘积是j×(i−j)；
     * 将 i拆分成 j和 i-j的和，且 i-j继续拆分成多个正整数，此时的乘积是j×dp[i−j]。
     *
     *
     * 需要枚举法
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            // 这里写 j < i 会降低性能，最快的是 j <= i-j
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max((i-j)*j, dp[i-j]*j));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
