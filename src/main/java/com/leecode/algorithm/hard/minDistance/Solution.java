package com.leecode.algorithm.hard.minDistance;

public class Solution {
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.minDistance("horse","ros"));
    }
    /**
     * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     */

    /**
     * 定义dp[i][j]为单词word1[0:i]与work2[0:j]所需要最少操作数
     * （意味着dp[i][j]的意思是经过最少操作数，已经达成一致）
     * （潜在的意思是子任务dp[i][j]已经完成）
     * 问题规模缩小的办法主要是
     * 如果word1[i+1] == work2[j+1]
     * 由于每个单词最后面多了一个同样的字符，不会影响最少操作数
     * 则dp[i+1][j+1] = dp[i][j]
     *
     * 如果word1[i+1] != work2[j+1]
     *
     * 则dp[i+1][j+1] = MAX(dp[i+1][j]+1, dp[i][j+1]+1, dp[i][j]+1)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }

        }
        return dp[word1.length()][word2.length()];
    }
}
