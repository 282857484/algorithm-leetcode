package com.leecode.algorithm.middle.canPartition;

import java.util.Arrays;

public class Solution1 {
    /**
     * ???
     * 只执行了1ms！
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums)
    {
        Arrays.sort(nums);
        int first = 0;
        int second = 0;
        int maxIndex = nums.length - 1;
        for (int i = maxIndex; i >= 0; i --)
        {
            if (first < second)
            {
                first += nums[i];
            }
            else
            {
                second += nums[i];
            }
        }
        if (first == second)
        {
            return true;
        }

        int sum = first + second;
        int halfSum = sum >> 1;
        if ((sum & 1) == 1 || nums[maxIndex] > halfSum)
        {
            return false;
        }

        first = second = halfSum;
        for (int i = maxIndex; i >= 0; i--)
        {
            if (first >= nums[i])
            {
                first -= nums[i];
            }
            else
            {
                second -= nums[i];
            }
        }
        return first == second;
    }
}
