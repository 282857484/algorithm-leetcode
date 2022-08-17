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
class Solution1 {
    public static void main(String[] args) {
        Solution1 s= new Solution1();


        for (String str: s.generateParenthesis(3)) {
            System.out.println("结果:" +str);
        }
    }

    public char[] arr = null;
    public Set<String> set = new HashSet();
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        arr = new char[n*2];
        gen(0,n,n);
        for (String s :
                set) {
            l.add(s);
        }
        return l;
    }

    private void gen(int cur, int m, int n) {
        if (m == 0 && n == 0){
            set.add(new String(arr));
        } else {
            if (m == n) {
                arr[cur] = '(';
                gen(cur+1, m-1, n);
            } else {
                if (m == 0) {
                    arr[cur] = ')';
                    gen(cur+1, m, n-1);
                } else {
                    arr[cur] = '(';
                    gen(cur + 1, m - 1, n);
                    arr[cur] = ')';
                    gen(cur + 1, m, n - 1);
                }
            }
        }

    }

}