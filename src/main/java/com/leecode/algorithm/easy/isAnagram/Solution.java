package com.leecode.algorithm.easy.isAnagram;

/**
 * 242.有效的字母异位词
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashs = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            hashs[chars[i]-'a']++;
        }

        char[] chart = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            hashs[chart[i]-'a']--;
            if (hashs[chart[i]-'a'] < 0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagramX(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashs = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            hashs[chars[i]-'a']++;
        }

        int[] hasht = new int[26];
        char[] chart = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            hasht[chart[i]-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hasht[i] != hashs[i]) {
                return false;
            }
        }
        return true;
    }
}
