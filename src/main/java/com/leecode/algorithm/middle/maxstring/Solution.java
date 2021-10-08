package com.leecode.algorithm.middle.maxstring;

import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 用数组做位置散列表，ascii字符都能落在128以内
        int[] last_location = new int[128];
        int window_start = 0;
        int max_length = 0;

        for (int i = 0; i < 128; i++){
            last_location[i] = -1;
        }
        // i为窗口右侧指针
        for (int i = 0; i < s.length(); i++) {
            int charNum = s.charAt(i);
            int char_last_location = last_location[charNum];
            if (window_start > char_last_location) {
                // 上次同样的字符出现在窗口外，不用管可继续扩大此窗口
                int  current_windows_size = i - window_start + 1;
                max_length = Math.max(max_length, current_windows_size);
            } else {
                // 同样的字符出现在窗口内，之前序列不可能出现更大的窗口，将窗口起始指针移动到这个重复字节+1位置
                window_start = char_last_location + 1;
            }
            // 每次移动最后一个窗口指针要更新位置记录表
            last_location[charNum] = i;
        }
        return max_length;
    }












    public int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        if (norepeatString(s)) {
            return s.length();
        } else {
            // substring 左开右闭所以 <  <=
            for (int begin = 0; begin < s.length(); begin++){
                for (int end = begin +1; end <= s.length(); end++){
                    if (norepeatString(s.substring(begin,end))) {
                        max = Math.max(max, s.substring(begin,end).length());
                    }
                }
            }
        }

        return max;
    }
    public boolean norepeatString(String s){
        char[] dst = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j<s.length(); j++) {
                if (dst[i] == dst[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
