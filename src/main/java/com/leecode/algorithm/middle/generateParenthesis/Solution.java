package com.leecode.algorithm.middle.generateParenthesis;

import java.util.*;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();


        for (String str: s.generateParenthesis(3)) {
            System.out.println("结果:" +str);
        }
    }

    char[] cur = null;
    int n = 0;
    Set<String> list = new HashSet<String>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        cur = new char[2 * n];
        recallParenthesis(0, 0, 0);
        return Arrays.asList( list.toArray(new String[n]));
    }

    private void recallParenthesis(int pos, int leftNum, int rightNum) {
        if (leftNum == n && rightNum == n)  {
            list.add(new String(cur));
            return;
        }
        if (leftNum == n && rightNum != n)  {
            cur[pos] = ')';
            recallParenthesis(pos + 1, leftNum, rightNum + 1);
        } else if (leftNum > rightNum) {
            cur[pos] = '(';
            recallParenthesis(pos + 1, leftNum + 1, rightNum);

            cur[pos] = ')';
            recallParenthesis(pos + 1, leftNum, rightNum + 1);
        } else {
            cur[pos] = '(';
            recallParenthesis(pos + 1, leftNum + 1, rightNum);
        }
    }
}