package com.leecode.algorithm.middle.restoreIpAddresses;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.restoreIpAddresses("0279245587303").stream().forEach(x -> System.out.println(x));
    }


    private List ipList = new ArrayList();
    private char[] ip;
    private char[] ori;

    public List<String> restoreIpAddresses(String s) {
        ip = new char[s.length() + 3];
        ori = s.toCharArray();
        for (int i = 0; i < ori.length; i++) {
            ip[i] = ori[i];
        }
        dfsIp(0, 0);
        return ipList;
    }

    /**
     * 解决第n层的问题
     * 出口是n==3
     *
     * @param n
     * @param startPos
     */
    public void dfsIp(int n, int startPos) {
        if (n == 3) {
            ipList.add(new String(ip));
            return;
        }
        // 逗号在i的后一位
        for (int i = startPos; i < startPos + 3; i++) {
            // 判断加了逗号前面的数字是否满足 0-255
            if (startPos > ip.length - 1) {
                continue;
            }
            if (ip[startPos] == '0' && (i - startPos) > 0) {
                continue;
            }
            if ((i + 1) > (ip.length-1)) {
                continue;
            }
            String num = new String(Arrays.copyOfRange(ip, startPos, i + 1));
            if (num.trim().length() == 0) {
                continue;
            }
            if (Integer.valueOf(num.trim()) > 255) {
                continue;
            }
            if (n == 2) {
                if (ip[i + 1] == '0' && (ip.length - i - 3) > 0) {
                    continue;
                }
                String lastNum = new String(Arrays.copyOfRange(ip, i + 1, ip.length - 1));
                if (lastNum.trim().length() == 0) {
                    continue;
                }
                if (Long.valueOf(lastNum.trim()) > 255L) {
                    continue;
                }
            }
            addComma(i + 1);
            dfsIp(n + 1, i + 2);
            deleteComma(i + 1);
        }
    }

    private void deleteComma(int i) {
        for (int j = i; j < ip.length - 1; j++) {
            ip[j] = ip[j + 1];
        }
        ip[ip.length - 1] = ' ';
    }

    private void addComma(int i) {
        for (int j = ip.length - 1; j > i; j--) {
            ip[j] = ip[j - 1];
        }
        ip[i] = '.';
    }

}
