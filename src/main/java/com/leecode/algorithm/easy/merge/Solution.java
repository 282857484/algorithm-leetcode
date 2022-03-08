package com.leecode.algorithm.easy.merge;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
class Solution {
    /**
     * 双指针
     * 时间复杂度m+n
     * 空间复杂度m+n
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeX(int[] nums1, int m, int[] nums2, int n) {
        int cur = 0;
        int[] merge = new int[m+n];
        int mx = 0;
        int nx = 0;
        while (!(mx == m && nx == n)) {
            if (nx == n) {
                merge[cur] = nums1[mx];
                mx++;
            } else if (mx == m) {
                merge[cur] = nums2[nx];
                nx++;
            } else if (nums1[mx] >= nums2[nx]) {
                merge[cur] = nums2[nx];
                nx++;
            } else {
                merge[cur] = nums1[mx];
                mx++;
            }
            cur++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merge[i];
        }
    }
    /**
     * 反向双指针
     * 时间复杂度m+n
     * 空间复杂度1
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while (!(p1==-1 && p2==-1)){
            if (p1==-1) {
                nums1[p] = nums2[p2];
                p2--;
            }else if(p2==-1) {
                nums1[p] = nums1[p1];
                p1--;
            }else if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

}