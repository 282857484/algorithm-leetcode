package com.leecode.algorithm.easy.search;

/**
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     *
     * 关键点是区间判断条件l<=r
     * 区间收缩要把当前点剔除,所以左减一右加一
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                r = mid-1;
            } else if(target > nums[mid]) {
                l = mid+1;
            }
        }
        return -1;
    }
    public int searchX(int[] nums, int target) {
        return findHalf(nums, 0, nums.length, target);
    }
    public int findHalf(int[] nums, int start_pos ,int end_pos, int target){
        int half = (start_pos + end_pos) / 2;
        if (half == 0) {
            if (nums[0] > target) {
                return -1;
            }
        }
        if (half == nums.length){
            return -1;
        }
        if (start_pos == end_pos) {
            return -1;
        }
        if (nums[half] == target) {
            return half;
        } else if (nums[half] > target)  {
            return findHalf(nums, start_pos, half, target);
        } else {
            return findHalf(nums, half + 1, end_pos, target);
        }
    }
}
