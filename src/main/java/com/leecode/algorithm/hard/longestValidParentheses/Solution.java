package com.leecode.algorithm.hard.longestValidParentheses;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestValidParentheses("())");
    }

    public int longestValidParentheses(String s) {
        if (s.length()<2) {
            return 0;
        }
        char[] parentheses = s.toCharArray();
        // dp[i]含义是以i为结尾的最长有效值
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (parentheses[i] == ')') {
                if ((i - dp[i - 1] - 1) < 0) {
                    dp[i] = 0;
                } else {
                    if (parentheses[i - dp[i - 1] - 1] == '(') {
                        if ((i - dp[i - 1] - 2) < 0) {
                            dp[i] = dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        }

                    } else {
                        dp[i] = 0;
                    }
                }

            } else {
                dp[i] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public int longestValidParenthesesX(String s) {
        char[] parentheses = s.toCharArray();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, validParenthesesLen(parentheses, i));
        }
        return max;
    }

    private int validParenthesesLen(char[] parentheses, int i) {
        int u = 0;
        Stack s = new Stack();
        for (int j = i; j >= 0; j--) {
            if (parentheses[j] == ')') {
                s.push(parentheses[j]);
            } else {
                if (s.size() < 1) {
                    return u;
                } else {
                    s.pop();
                }
            }
            if (s.size() == 0) {
                u = i - j + 1;
            }
        }
        return u;
    }
}
