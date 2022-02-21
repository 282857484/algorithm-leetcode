package com.leecode.algorithm.middle.longestCommonSubsequence;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        int alength = a.length;
        int blength = b.length;
        int[][] dp = new int[alength+1][blength+1];
        for (int j = 0; j < blength; j++) {
            for (int i = 0; i <alength; i++) {
                if (a[i] == b[j]) {
                    dp[i+1][j +1] = dp[i][j] +1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[alength][blength];
    }
}
