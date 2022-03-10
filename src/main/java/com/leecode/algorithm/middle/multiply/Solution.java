package com.leecode.algorithm.middle.multiply;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("1111","1234"));
    }

    // 计算类的进位不会弄就全扔外边
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int a = num1.length() + num2.length();
        int[] result = new int[num1.length() + num2.length() ];
        for (int i = num1.length()-1; i >= 0; i--) {
            int x = n1[i]-'0';
            for (int j = num2.length()-1; j >= 0; j--) {
                int y = n2[j]-'0';
                int q = x*y % 10;
                int p = x*y / 10;
                // 低位
                result[i+j+1] = result[i+j+1] + q;
                // 高位
                result[i+j] = result[i+j] + p;
            }
        }

        // 处理进位，不好处理进位就在外面进位！
        int carry = 0;
        for (int i = result.length-1; i >= 0; i--) {
            int act = result[i]+carry;
            result[i] = (act) % 10;
            carry = act / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0)
                continue;
            sb.append(result[i]);
        }
        return sb.toString();

    }



}
