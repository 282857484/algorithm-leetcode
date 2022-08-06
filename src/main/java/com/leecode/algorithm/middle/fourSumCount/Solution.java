package com.leecode.algorithm.middle.fourSumCount;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 *
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 这里需要计算数量，所以需要用hashmap来存储数量
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = -nums3[i]-nums4[j];
                cnt += map.getOrDefault(key, 0);
            }
        }
        return cnt;
    }
}
