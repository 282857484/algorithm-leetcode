package com.leecode.algorithm.middle.longestConsecutive;

import java.util.HashMap;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 示例 1：
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Solution {
    public static void main(String[] agrs) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public int longestConsecutive(int[] nums) {
        int max = 0;
        // key 是 nums中的值，value是连续的值
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            boolean x1 = map.containsKey(nums[i] - 1);
            boolean x2 = map.containsKey(nums[i] + 1);
            int cnt = 1;
            int leftLength = 0;
            int rightLength = 0;
            if (x1) {
                leftLength = map.get(nums[i] - 1);
                cnt += leftLength;
            }
            if (x2) {
                rightLength = map.get(nums[i] + 1);
                cnt += rightLength;
            }
            map.put(nums[i], cnt);
            if (leftLength > 0) {
                map.put(nums[i] - leftLength, cnt);
            }
            if (rightLength > 0) {
                map.put(nums[i] + rightLength, cnt);
            }
            max = Math.max(cnt, max);
        }
        return max;
    }
}
