package com.leecode.algorithm.easy.intersection;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set num1Set = new HashSet<>();
        HashSet<Integer> result = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (num1Set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] r = new int[result.size()];
        Integer[] rs = result.toArray(new Integer[result.size()]);
        for (int i = 0; i < r.length; i++) {
            r[i] = rs[i];
        }
        return r;
    }
}
