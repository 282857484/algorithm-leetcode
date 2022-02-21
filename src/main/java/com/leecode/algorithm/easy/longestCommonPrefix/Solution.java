package com.leecode.algorithm.easy.longestCommonPrefix;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:");

    }
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int maxCommon = 0;
        boolean signal = false;
        for (int i = 0; i < minLength; i ++) {
            // char 仅由小写字母组成
            char common = '0';
            for (String str : strs) {
                char x = str.charAt(i);
                if (common == '0') {
                    common = x;
                } else if (x == common) {

                } else if (x != common) {
                    signal = true;
                }
            }
            if (signal == true) {
                break;
            }
            maxCommon ++;
        }
        return strs[0].substring(0, maxCommon);
    }
}