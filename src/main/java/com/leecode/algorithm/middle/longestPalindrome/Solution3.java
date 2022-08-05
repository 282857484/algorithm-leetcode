package com.leecode.algorithm.middle.longestPalindrome;

public class Solution3 {
    /**
     * 动态规划
     * dp[n][n] = TRUE
     * dp[i][j] = (c[i] == c[j]) && dp[i+1][j-1]
     *
     * j\i  0 1 2 3 4 5
     * 0    T
     * 1      T
     * 2        T
     * 3      y   T
     * 4    x       T
     * 5              T
     * （任意x位置依赖y位置，所以遍历有两种方式，一种是固定字符串长度遍历字符串；一种是固定j的位置遍历i；）
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        char[] c = s.toCharArray();
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (c[i] != c[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }




}
