package com.leecode.algorithm.middle.merge;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] -o2[0];
        });
        return null;
    }
}