package com.leecode.algorithm.easy.firstBadVersion;

public class Solution extends VersionControl{
    public Solution(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Solution s = new Solution(4);
        System.out.println(s.firstBadVersion(5));
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) { // 找第一个错误的版本
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
