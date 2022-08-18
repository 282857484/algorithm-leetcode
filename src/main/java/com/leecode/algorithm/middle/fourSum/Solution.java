package com.leecode.algorithm.middle.fourSum;

import java.util.*;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class Solution {
    /**
     * 与三数之和类似
     * 排序+双指针
     * 比暴力解法降一个维度
     * 外层循环i、j是枚举最左边的两个元素
     * 1、需要不重复的四元组
     * 2、难点是去重需要hashset
     * 3、剪枝
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> ll = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ll;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long t = (long)target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[left] + nums[right];
                    if (sum == t) {
                        List l = new ArrayList(4);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        String key = nums[i] + "|" + nums[j] + "|" + nums[left] + "|" + nums[right];
                        if (!set.contains(key)) {
                            ll.add(l);
                            set.add(key);
                        }
                        left++;
                        right--;
                    } else if (sum > t) {
                        right--;
                    } else if (sum < t) {
                        left++;
                    }
                }
            }
        }
        return ll;
    }

    // if裁剪条件改良运算时间
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> ll = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ll;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // 这三个判断竟然能降低一个数量级的运行市场112ms->16ms
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 这三个判断竟然能降低一个数量级的运行市场16ms->12ms
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }

                long t = (long)target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[left] + nums[right];
                    if (sum == t) {
                        List l = new ArrayList(4);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        String key = nums[i] + "|" + nums[j] + "|" + nums[left] + "|" + nums[right];
                        if (!set.contains(key)) {
                            ll.add(l);
                            set.add(key);
                        }
                        left++;
                        right--;
                    } else if (sum > t) {
                        right--;
                    } else if (sum < t) {
                        left++;
                    }
                }
            }
        }
        return ll;
    }

    /**
     * 可以将问题抽象为一个三维动态规划的空间
     * dp[i][j][k]的值代表是否有元组可以满足，i代表nums的维度，j代表元组大小维度（这里是四个元素），k代表目标值target维度
     * dp[i][j][k] = dp[i-1][j][k] || dp[i-1][j-1][k-nums[i]]
     * TODO
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSumDP(int[] nums, int target) {
        return null;
    }

    /**
     * 错误：不能堆nums进行去重
     * 应该对结果集去重
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSumX(int[] nums, int target) {
        Arrays.sort(nums);
        // 数组去重 快慢指针这个是错的
        int nLen = removeRepeatElement(nums);
        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < nLen; i++) {
            for (int j = i+1; j < nLen; j++) {
                int t = target - nums[i] - nums[j];
                int left = 0;
                int right = nums[nLen-1];
                while (left < right) {
                    if (left == i) {
                        left++;
                    } else if (right == j) {
                        right--;
                    } else {
                        int sum = nums[left] + nums[right];
                        if (sum == t) {
                            List l = new ArrayList(4);
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[left]);
                            l.add(nums[right]);
                            ll.add(l);
                            break;
                        } else if (sum > t) {
                            right--;
                        } else if (sum < t) {
                            left++;
                        }
                    }
                }
            }
        }
        return ll;
    }

    /**
     *
     * @param nums
     * @return 去重后nums的长度
     */
    private int removeRepeatElement(int[] nums) {
        int slow = 0;
        for (int quick = 0; quick < nums.length; quick++) {
            if (nums[slow] != nums[quick]) {
                slow ++;
                nums[slow] = nums[quick];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ll = s.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
        ll.forEach(l -> {
            l.forEach(x -> System.out.print(x + ","));
            System.out.println("");
        });
        ll = s.fourSum(new int[]{2,2,2,2,2}, 0);
        ll.forEach(l -> {
            l.forEach(x -> System.out.print(x + ","));
            System.out.println("");
        });
        ll = s.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        ll.forEach(l -> {
            l.forEach(x -> System.out.print(x + ","));
            System.out.println("");
        });

    }
}
