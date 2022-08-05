package com.leecode.algorithm.easy.backspaceCompare;

/**
 * 844. 比较含退格的字符串
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean aa = s.backspaceCompare("a#c","b");
        System.out.println(aa);
    }

    public boolean backspaceCompare(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (backspace(sArr).equals(backspace(tArr))) {
            return true;
        } else {
            return false;
        }
    }

    private String backspace(char[] arr) {
        int quick = 0;
        int cur = 0;
        while (quick != arr.length) {
            if (arr[quick] == '#') {
                if (cur > 0) {
                    cur--;
                }
                quick++;
            } else {
                arr[cur] = arr[quick];
                cur++;
                quick++;
            }
        }
        if (cur == 0) {
            return "";
        }
        return new String(arr).substring(0,cur);
    }
}
