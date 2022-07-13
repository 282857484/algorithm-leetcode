package com.leecode.algorithm.middle.searchRange;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
    }


    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);
        return new int[] {leftIndex, rightIndex};
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                ans = mid;
                if (isLeft) {
                    r = mid - 1;
                } else {
                    l = mid+1;
                }
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            }
        }
        return ans;
    }







    public int[] searchRangeX(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

//    public int binarySearch(int[] nums, int target, boolean lower) {
//        int left = 0, right = nums.length - 1, ans = nums.length;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] > target || (lower && nums[mid] >= target)) {
//                right = mid - 1;
//                ans = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }
}
