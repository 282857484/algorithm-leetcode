package com.leecode.algorithm.interview;

public class maintest {
    public static void main(String[] args) {
        maintest x= new maintest();
        System.out.println(x.addBinary("101010011", "11011"));

        String a = "123123123123123123";
        String b = "123123123123123423";
        if (a.compareTo(b) > 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    public int reverse(int x) {
        StringBuilder reverse = new StringBuilder();
        while (x != 0) {
            int y = x % 10;
            x /= 10;
            reverse.append(y);
        }
        String reverseNum = reverse.reverse().toString();
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        if (x > 0) {
            if (max.compareTo(reverseNum) < 0) {
                return 0;
            } else {
                return Integer.valueOf(reverseNum);
            }
        } else {
            if (min.compareTo(reverseNum) < 0) {
                return 0;
            } else {
                return Integer.valueOf(reverseNum) * -1;
            }
        }
    }

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
            result[result.length-1] = 1;
        }

        StringBuilder cc = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            cc.append(result[i]);
        }
        return cc.toString().trim();

    }
}
