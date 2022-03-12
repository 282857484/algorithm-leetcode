package com.leecode.algorithm.middle.divide;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648,-2147483648));
    }
    /**
     * 思路1：暴力搜索
     * 思路2：快速幂搜索
     * 难点：边界太麻烦
     */
    public int divide(int dividend, int divisor) {
        boolean fuck = false;
        // 考虑被除数为最小值的情况（int范围 -2^31，2^31 -1）
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            dividend ++;
            fuck = true;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        boolean rev = true;
        if (dividend < 0) {
            rev = !rev;
            dividend = -dividend;
        }
        if (divisor < 0) {
            rev = !rev;
            divisor = -divisor;
        }
        // 当前结果
        int res = 0;
        // 余值
        int l = dividend;
        // 正在除出来的值
        int d = divisor;
        // 当前倍率
        int x = 1;
        int t1 = 0;
        int t2 = 0;
        while (l >= d) {
            t1 = d;
            t2 = x;
            d = d << 1;
            x = x << 1;
            if (d > 0) {
                if (l < d) {
                    d = d >> 1;
                    x = x >> 1;
                    l -= d;
                    res += x;
                    // 归位
                    d = divisor;
                    x = 1;
                }
            } else {
                // 特殊情况
                d = t1;
                x = t2;
                l -= d;
                res += x;
                // 归位
                d = divisor;
                x = 1;
            }
        }

        if (fuck) {
            l++;
            if (l >= divisor) {
                res ++;
            }
        }
        if (!rev) {
            res = -res;
        }
        return res;
    }
}
