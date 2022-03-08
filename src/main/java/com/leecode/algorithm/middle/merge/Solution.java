package com.leecode.algorithm.middle.merge;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] -o2[0];
        });
        int cur = 0;
        int[][] mergeIntervals = new int[intervals.length][2];
        mergeIntervals[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (mergeIntervals[cur][1] >= intervals[i][0]) {
                mergeIntervals[cur][1] = Math.max(mergeIntervals[cur][1], intervals[i][1]);
            } else {
                cur ++;
                mergeIntervals[cur] = intervals[i];
            }
        }
        int[][] result = new int[cur+1][];
        for (int i = 0; i < result.length; i++) {
            result[i] = mergeIntervals[i];
        }
        return result;
    }
}