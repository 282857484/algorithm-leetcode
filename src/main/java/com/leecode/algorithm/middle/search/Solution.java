package com.leecode.algorithm.middle.search;

import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（
 * 下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，
 * 则返回它的下标，否则返回-1。
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(new int[]{3,1},4);
    }
    // O(n)
    public int search(int[] nums, int target) {
        int barries = minArrayNum(nums);
        int a = Arrays.binarySearch(nums,0,barries,target);
        int b = Arrays.binarySearch(nums,barries,nums.length,target);
        // a和b需要取最小值
        return Math.max(Math.max(a,b), -1);
    }

    /**
     * 可以有重复数字的搜索最小值的位置
     * @param numbers
     * @return
     */
    public int minArrayNum(int[] numbers) {
        if (numbers[0] < numbers[numbers.length-1]) {
            return 0;
        }

        int leftBar = 0;
        int rightBar = numbers.length-1;
        int bigger = numbers[0];
        while (leftBar < rightBar) {
            int mid = (leftBar + rightBar)/2;
            if (numbers[mid] > bigger) {
                leftBar = mid + 1;
            } else if (numbers[mid] < bigger) {
                rightBar = mid;
            } else {
                // 找到的值是跟头重复的，这时无法判断是哪个区间，只能逐渐缩小范围
                // 如果现在的左边界比bigger要小，那么现在就是最小值
                if (numbers[leftBar] < bigger) {
                    return leftBar;
                }

                // 如果他的下一个值大于等于bigger
                if (numbers[leftBar+1] >= bigger){
                    // 并且当前left值被bigger小
                    leftBar++;
                } else {
                    return leftBar+1;
                }
            }
        }
        return leftBar;
    }
}
