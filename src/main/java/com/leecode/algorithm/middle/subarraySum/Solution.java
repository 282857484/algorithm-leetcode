package com.leecode.algorithm.middle.subarraySum;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:"+s.subarraySum(new int[]{1,-1,0}, 0));
    }
    // 可以用滑动窗口解决但是复杂度是n^2

    // 这种是复杂度n
    // m[0:i] + m[i:j] = m[0:j]
    // k = m[i:j]
    // if m[0:i] == m[0:j] - k;  then count++
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        // preArraySum 序列值之和
        int preArraySum = 0;
        int count = 0;
        for (int i: nums) {
            preArraySum += i;
            if (map.containsKey(preArraySum - k)) {
                count += map.get(preArraySum - k);
            }
            map.put(preArraySum, map.getOrDefault(preArraySum, 0) + 1);
        }

        return count;
    }

}