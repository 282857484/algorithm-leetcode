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

    public static String palindromeY(String s) {
        int maxlength = 0;
        int jj = 0;
        byte[] ss = s.getBytes();
        // 假设i为回文中心
        for (int i = 0; i < ss.length; i ++) {
            int imax = 1;
            for(int j = i; (j > 0) && ((2*i-j) < ss.length); j--) {
                if (ss[j] == ss[2*i-j]){
                    imax ++;
                }
            }
            if (imax > maxlength) {
                maxlength = imax;
                jj = i;
            }
        }
        return s.substring(jj - maxlength, jj + maxlength-1);
    }


}
