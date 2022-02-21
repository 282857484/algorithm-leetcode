package com.leecode.algorithm.hard.longestDupSubstring;

import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * 最长重复字符串
     * 基于枚举
     * 暴力做法：列出所有子串然后hash查找
     * 优化做法：查找是否有长度为n-1的重复子串，如果没有则缩减子串长度直到为1
     * 进一步优化：[1,n-1]的长度中二分长度，进行查询
     *
     * 检查固定长度子串有重复的算法
     * Rabin-Karp查找固定长度的子串在原串中是否出现过
     * 原理是通过一个固定大小的滑动窗口，对每个字符串求hash值
     * 字符串求哈希值的方法，对字符串每一位乘一个质数，然后相加的值
     **/
    public String longestDupSubstring(String s) {
        // [1,n-1]的长度中二分长度，进行查询


        return "";
    }
    //随意的质数
    int zhishu = 17;
    /**
     * Rabin-Karp
     * 返回重复字符串的索引
     * 如果有指定长度的重复字符串则返回重复字符串的索引
     * 如果没有指定长度的重复字符串则返回-1
     *
     * @param length
     * @param s
     * @return
     */
    public int check(int length,String s) {
        Set<Integer> set = new HashSet<>();
        //先检查hash值是否一致
        for (int i = 0; i < (s.length() - length); i++) {
            int hash = s.substring(i,i+length).hashCode();
            if (set.contains(hash)) {

            }
        }

        return -1;
    }
    // 如果hash一致再按char检查每一个字符
    public boolean checkByChars(String a, String b){
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int getStringHash(String s) {
        return 0;
    }
}