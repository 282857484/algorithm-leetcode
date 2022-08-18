package com.leecode.algorithm.middle.letterCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    char[] result;
    List<String> list;
    char[][] chars = new char[][]{{'a','b','c'},{'d','e','f',},{'g','h','i',}
            ,{'j','k','l',},{'m','n','o',},{'p','q','r','s'}
            ,{'t','u','v',},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        result = new char[digits.length()];

        char[] d = digits.toCharArray();
        dfs(d, 0);
        return list;
    }

    private void dfs(char[] d, int i) {
        if (i == d.length){
            list.add(new String(result));
            return;
        }
        char[] x = chars[d[i]-'2'];
        for (int j = 0; j < x.length; j++) {
            if (x[j] >= 'a' && x[j] <= 'z') {
                result[i] = x[j];
                dfs(d, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.letterCombinations("234234").forEach(a -> System.out.println(a));
    }
}
