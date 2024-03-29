package com.leecode.algorithm.easy.fib;

/**
 * 509. 斐波那契数
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class Solution {
    public int fibX(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fib(n-1) + fib(n-2)) % 1000000007;
        }
    }
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 509. 斐波那契数
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0)  {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int last1 = 0;
        int last2 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = last1 + last2;
            last1 = last2;
            last2 = cur;
        }
        return last2;
    }
}
