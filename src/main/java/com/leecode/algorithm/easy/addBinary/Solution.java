package com.leecode.algorithm.easy.addBinary;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 *
 *
 * 示例1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String addBinary(String a, String b) {
        // 可能进位
        char[] result = new char[Math.max(a.length(), b.length()) + 1];
        StringBuilder aa = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            aa.append(a.charAt(i));
        }
        char[] ac = aa.toString().toCharArray();

        StringBuilder bb = new StringBuilder();
        for (int i = b.length() - 1; i >= 0; i--) {
            bb.append(b.charAt(i));
        }
        char[] bc = bb.toString().toCharArray();
        // 先加起来不管进位
        int n = Math.max(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            if (i < ac.length && i < bc.length) {
                int x = ac[i] - '0';
                int y = bc[i] - '0';
                result[i] = (char) (x + y + '0');
            } else if (i < bc.length) {
                result[i] = bc[i];
            } else if (i < ac.length) {
                result[i] = ac[i];
            }
        }
        // 管进位
        int carry = 0;
        for (int i = 0; i < result.length; i++) {
            if (carry == 1) {
                if (result[i] - '0' == 0) {
                    result[i] = '1';
                    carry = 0;
                } else if (result[i] - '0' == 1) {
                    result[i] = '0';
                    carry = 1;
                } else if (result[i] - '0' == 2) {
                    result[i] = '1';
                    carry = 1;
                }
            } else {
                if (result[i] - '0' == 0) {
                    result[i] = '0';
                    carry = 0;
                } else if (result[i] - '0' == 1) {
                    result[i] = '1';
                    carry = 0;
                } else if (result[i] - '0' == 2) {
                    result[i] = '0';
                    carry = 1;
                }
            }

        }
        if (carry == 1) {
            result[result.length-1] = '1';
        }

        StringBuilder cc = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            cc.append(result[i]);
        }
        return cc.toString().trim();

    }
}
