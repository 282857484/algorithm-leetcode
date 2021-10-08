package com.leecode.algorithm.middle.longestPalindrome;

public class Solution {
    public String longestPalindrome(String s) {
        String max_char = "";
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // odd str
            String oddstr = findPalindromeStr(s, i, i);
            if (oddstr != null) {
                if (max_char.length() < oddstr.length()) {
                    max_char = oddstr;
                }
            }
            // even str
            String evenstr = findPalindromeStr(s, i, i + 1);
            if (evenstr != null) {
                if (max_char.length() < evenstr.length()) {
                    max_char = evenstr;
                }
            }
        }
        return max_char;
    }

    private String findPalindromeStr(String str, int j, int k) {
        if (j > str.length() - 1 || k > str.length() - 1 || j < 0 || k < 0) {
            return null;
        }
        if (str.charAt(j) != str.charAt(k)) {
            return str.substring(j, j + 1);
        }
        while (true) {
            if ((j - 1) < 0 || (k + 1) > str.length() - 1) {
                break;
            }
            if (str.charAt(j - 1) == str.charAt(k + 1)) {
                j--;
                k++;
            } else {
                break;
            }
        }
        return str.substring(j, k + 1);
    }


}
