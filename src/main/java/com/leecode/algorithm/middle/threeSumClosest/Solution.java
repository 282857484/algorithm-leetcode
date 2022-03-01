package com.leecode.algorithm.middle.threeSumClosest;


import java.util.Arrays;

class Solution {
    /**
     * 16. 最接近的三数之和
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * 返回这三个数的和。
     * 假定每组输入只存在恰好一个解。
     *
     * 双指针比二分搜索快很多
     */

    /**
     * 固定a，bc双指针缩小范围
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int absMin = Integer.MAX_VALUE;
        int threeSum = 0;
        Arrays.sort(nums);
        // 固定a值
        for (int a = 0; a < nums.length; a++) {
            int b = a+1;
            int c = nums.length - 1;
            while (b<c) {
                int x = nums[a] + nums[b] + nums[c];
                if (x > target){
                    c--;
                    int abs = Math.abs(target - x);
                    if (abs < absMin) {
                        absMin = abs;
                        threeSum = x;
                    }
                } else {
                    b++;
                    int abs = Math.abs(target - x);
                    if (abs < absMin) {
                        absMin = abs;
                        threeSum = x;
                    }
                }
            }
        }
        return threeSum;
    }
    /**
     * 排序然后二分搜索，固定ab二分找c
     * 43ms
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosestX(int[] nums, int target) {
        int absMin = Integer.MAX_VALUE;
        int threeSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int t = target - nums[i] - nums[j];
                int[] x = binarySearch(nums, i + 1, nums.length, t);
                if (x[0] != i && x[0] != j && x[0] < nums.length) {
                    t -= nums[x[0]];
                    if (Math.abs(t) < absMin) {
                        absMin = Math.abs(t);
                        threeSum = nums[i] + nums[j] + nums[x[0]];
                    }
                    t += nums[x[0]];
                }
                if (x[1] != i && x[1] > 0 && x[1] != j && x[1] < nums.length) {
                    t -= nums[x[1]];
                    if (Math.abs(t) < absMin) {
                        absMin = Math.abs(t);
                        threeSum = nums[i] + nums[j] + nums[x[1]];
                    }
                }

            }
        }

        return threeSum;
    }

    private static int[] binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else {
                return new int[]{mid, -1};
            } // key found
        }
        return new int[]{low - 1, high + 1};  // key not found.
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("结果:" + s.threeSumClosest(new int[]{-1,2,1,-4}, 1));

        // for (T t : s.func()) { System.out.println("结果:" + t);}
    }
}