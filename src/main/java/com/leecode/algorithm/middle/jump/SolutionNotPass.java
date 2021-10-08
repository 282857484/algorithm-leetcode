package com.leecode.algorithm.middle.jump;

import java.lang.reflect.Array;

class SolutionNotPass {
    int MAX_INT = 0x70000000;
    int[] lessResult = null;
    public int jump(int[] nums) {
        lessResult = new int[nums.length];
        for (int i = 0; i< nums.length; i++){
            lessResult[i] = MAX_INT;
        }
        return jumpFrom(0, 0, nums);
    }

    // 从start到终点需要多少步
    private int jumpFrom(int start, int stepCnt,int[] nums) {
        if (start == nums.length-1) {
            return 0;
        }
        if (start > nums.length-1) {
            return MAX_INT;
        }
        if (lessResult[start] < stepCnt) {
            return MAX_INT;
        }
        int step = nums[start];
        if (step == 0) {
            return MAX_INT;
        } else {
            int min = MAX_INT;
            for (int i = 1; i <= step ; i++){
                int jp = jumpFrom(start + i, stepCnt+1, nums) + 1;
                min = Math.min(min, jp);
                if ((start + i) < nums.length-1) {
                    if (lessResult[start + i] > jp) {
                        lessResult[start + i] = jp;
                    }
                }
            }
            return min;
        }
    }
}
