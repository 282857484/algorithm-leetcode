package com.leecode.algorithm.hard.maxSlidingWindow;

import java.util.Stack;

/**
 *
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    /**
     * 最优解
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // pre用于记录当前窗口最大值下标
        int left = 0, right = k - 1, pre = -1, max = Integer.MIN_VALUE;

        while (right < n) {
            // 如果pre比left大或者和left相等
            // 就直接将上次的循环的最大值与新加进来的数进行比较，即nums[right]
            if (pre >= left) {
                if (nums[right] >= max) {
                    pre = right;
                    max = nums[right];
                }
                // 如果新加进来的nums[right]比原来的max大，就将right赋值给pre，然后将nums[right]赋值给max
            } else if (nums[right] >= max - 1) {
                pre = right;
                max = nums[right];
            } else if (nums[left] >= max - 1) {
                pre = left;
                max = nums[left];
            } else {
                // 开始的情况，第一个窗口
                max = Integer.MIN_VALUE;
                for (int i = left; i <= right; i ++) {
                    if (nums[i] >= max) {
                        pre = i;
                        max = nums[i];
                    }
                }
            }
            res[left] = max;
            left++;
            right++;
        }
        return res;
    }

    /**
     * 方法一：优先队列 时间复杂度：nlog(n) 空间复杂度：n
     * 方法二：单调队列 时间复杂度：n 空间复杂度：n
     *
     * @param nums
     * @param k 窗口大小
     * @return
     */
    public int[] maxSlidingWindowX(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        MonotonicStack mStack = new MonotonicStack();
        for (int i = 0; i < k-1; i++) {
            mStack.push(new PV(i,nums[i]));
        }
        for (int i = k-1; i < nums.length; i++) {
            mStack.expireHeadClean(i-k+1);
            mStack.push(new PV(i, nums[i]));
            result[i-k+1] = mStack.stack.firstElement().v;
        }

        return result;
    }
    class PV {
        public Integer p;
        public Integer v;
        public PV(Integer p, Integer v) {
            this.p = p;
            this.v = v;
        }
    }

    class MonotonicStack {
        public Stack<PV> stack;
        public MonotonicStack() {
            this.stack = new Stack();
        }

        /**
         * 单调栈方法压入元素
         * @param t
         * @return
         */
        public PV push(PV t) {
            while (true){
                if (stack.empty()) {
                    stack.push(t);
                    break;
                }
                if (stack.lastElement().v <= t.v) {
                    stack.pop();
                } else {
                    stack.push(t);
                    break;
                }
            }
            return t;
        }

        /**
         * 清理小于水位线的数据
         * @param waterLine
         */
        public void expireHeadClean(Integer waterLine) {
            while (!stack.empty()) {
                if (stack.firstElement().p < waterLine) {
                    stack.remove(0);
                } else {
                    break;
                }
            }
        }

    }
}
