package com.leecode.algorithm.easy.strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        for (int i = 0; i < h.length; i++) {
            boolean flag = true;
            for (int j = 0; j < n.length; j++) {
                if ((i+j) >= h.length || n[j] != h[i+j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("mississippi","issipi"));
    }
}
