package com.leecode.algorithm.easy.removeDuplicates;

import java.util.Stack;

public class Solution {
    public static void main(String[] agrs) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    /**
     * 26. 删除有序数组中的重复项
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
     * 将最终结果插入nums 的前 k 个位置后返回 k 。
     *
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     */
    public int removeDuplicates(int[] nums) {
        // 双指针
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
    /**
     * 1047. 删除字符串中的所有相邻重复项
     * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String removeDuplicatesX(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0) {
                stack.push(arr[i]);
            }else {
                if (stack.peek() == arr[i]) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: stack.toArray(new Character[stack.size()])) {
            sb.append(c);
        }
        return sb.toString();
    }
    public String removeDuplicates(String s) {
        // 双指针
        char[] stack = s.toCharArray();
        int top = 0;
        for (int i = 0; i < stack.length; i++) {
            if (top == 0) {
                stack[top] = stack[i];
                top++;
            } else {
                if (stack[top-1] == stack[i]) {
                    top--;
                } else {
                    stack[top] = stack[i];
                    top++;
                }
            }
        }
        if (top == 0) {
            return "";
        }
        return new String(stack).substring(0, top);
    }
}
