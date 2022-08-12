package com.leecode.algorithm.middle.isSubsequence;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class Solution {
    /**
     * 这个用贪心算法更快一些
     * 双指针
     * 一个指向s，一个指向t，然后找到一个相等
     * 时间复杂度O{m+n}
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        char[] a = t.toCharArray();
        char[] sa = s.toCharArray();
        if (sa.length > a.length) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < sa.length; i++) {
            if (j >= a.length) {
                return false;
            }
            for (; j < a.length; j++) {
                if (sa[i] == a[j]) {
                    j = j + 1;
                    break;
                }else if (j == a.length-1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isSubsequence("b", "c");
    }
}
