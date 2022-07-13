package com.leecode.algorithm.easy.majorityElement;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于[ n/2 ]的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int num: nums) {
            if (cnt == 0) {
                candidate = num;
            }
            if (candidate == num) {
                cnt ++;
            } else {
                cnt --;
            }
        }
        return candidate;
    }
}
