package com.leecode.algorithm.easy.minArray;

/**
 * 旋转数组的最小数字
 */

/**
 * 二分搜索的变形
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        s.minArray(new int[]{2,2,2,0,1});
        s.minArray(new int[]{1,2,2,2,0,1,1});
    }


    public int minArray(int[] numbers) {
        if (numbers[0] < numbers[numbers.length-1]) {
            return numbers[0];
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
                    return numbers[leftBar];
                }

                // 如果他的下一个值大于等于bigger
                if (numbers[leftBar+1] >= bigger){
                    // 并且当前left值被bigger小
                    leftBar++;
                } else {
                    return numbers[leftBar+1];
                }
            }
        }
        return numbers[leftBar];
    }
}
