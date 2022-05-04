package com.leecode.algorithm.middle.nextPermutation;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextPermutation(new int[]{1,2,3});
    }
    public void nextPermutation(int[] nums) {
        int fence = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                fence = i;
                break;
            }
            if (nums[i-1] < nums[i]) {
                fence = i;
                break;
            }
        }
        if (fence == 0) {
            // 反转整个数组
            reverseArray(nums, 0, nums.length - 1);
        } else {
            // 将fence - 1位与之后序列中比其大的第一个元素进行交换，并反转[fence: length-1]区间
            int tmp = nums[fence - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                if (tmp < nums[i]) {
                    nums[fence - 1] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
            reverseArray(nums, fence, nums.length - 1);
        }
    }

    private void reverseArray(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l ++;
            r --;
        }
    }
}
