package com.leecode.algorithm.middle.longestPalindrome;

public class Solution2 {
    /**
     * 中心扩展
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] c = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int oddLen = findMaxPalidrome(c, i, i);
            int evenLen = findMaxPalidrome(c, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     *
     * @param c
     * @param i
     * @param j
     * @return 长度
     */
    private int findMaxPalidrome(char[] c, int i, int j) {
        while (i > -1 && j < c.length && c[i] == c[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }


}
