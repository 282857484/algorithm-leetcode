package com.leecode.algorithm.middle.maxUncrossedLines;


public class Solution {
    /**
     * 连线不相交可以转换为最长公共子序列
     * dp[i][j]代表长度为i的序列a，与长度为j的序列b最长的公共子序列
     * 如果nums1[i]=nums2[j]
     * dp[i][j] = dp[i-1][j-1] + 1
     * 否则
     * dp[i][j] = max{dp[i-1][j],dp[i][j-1]}
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int imax = nums1.length;
        int jmax = nums2.length;
        // 创建时要多一层初始层
        int[][] dp = new int[imax + 1][jmax + 1];
        for (int j = 0; j < jmax; j++) {
            for (int i = 0; i < imax; i++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[imax][jmax];
    }
}