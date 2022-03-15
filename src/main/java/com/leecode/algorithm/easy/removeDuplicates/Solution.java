package com.leecode.algorithm.easy.removeDuplicates;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution {
    public static void main(String[] agrs) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int p1 = 1;
        int lastVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastVal) {
                lastVal = nums[i];
                nums[p1] = nums[i];
                p1++;
            }
        }
        return p1;
    }
    public int removeDuplicatesX(int[] nums) {
        int len = 1;
        int lastNum = nums[0];
        int cnt = 0;
        // 因为遇到数组整体左移，i的移动交给代码
        for (int i = 1; i < (nums.length-cnt); i++) {
            if (lastNum == nums[i]){
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                cnt++;
            } else {
                lastNum = nums[i];
                len++;
            }
        }
        return len;
    }
}
