package com.leecode.algorithm.middle.patternMatching;

public class Solution2 {
    int aCount;
    int bCount;

    public boolean patternMatching(String pattern, String value) {
        int patLen = pattern.length();
        int valLen = value.length();
        //1 pattern为""
        if (patLen == 0) {
            return valLen == 0;
        }
        //记录pattern中a,b的数量
        for (int i = 0; i < patLen; i++) {
            if (pattern.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }
        //2 pattern不为""
        //2.1 value为"",判断pattern是否为一种字符组成
        if (valLen == 0) {
            return aCount == 0 || bCount == 0;
        }
        //2.2.1 value不为"",处理pattern只有一种字符串的情况
        if (aCount == 0) {
            return helper(value, bCount);
        } else if (bCount == 0) {
            return helper(value, aCount);
        }
        //2.2.2 value不为"",处理pattern中'a'或'b'可为""的情况
        if (helper(value, aCount)) {
            return true;
        }
        if (helper(value, bCount)) {
            return true;
        }
        //2.2.3 value不为"",枚举'a','b'所代表的字符串长度
        //使得aCount*aLen+bCount*bLen=valLen
        for (int aLen = 1; aLen * aCount <= valLen - bCount; aLen++) {
            //valLen减去所有a代表的字符串,个数不够为bCount的倍数
            if ((valLen - aLen * aCount) % bCount != 0) {
                continue;
            }
            //通过aLen计算bLen
            int bLen = (valLen - aLen * aCount) / bCount;
            if (check(pattern, value, aLen, bLen)) {
                return true;
            }
        }
        return false;
    }

    boolean helper(String val, int k) {
        int len = val.length();
        if (len % k != 0) {
            return false;
        }
        int perStrLen = len / k;
        for (int i = perStrLen; i < len; i += perStrLen) {
            if (!val.substring(i, i + perStrLen).equals(val.substring(0, perStrLen))) {
                return false;
            }
        }
        return true;
    }

    boolean check(String pattern, String value, int aLen, int bLen) {
        String a = null;
        String b = null;
        for (int i = 0, j = 0; i < pattern.length(); i++) {
            //j每次移动aLen或bLen的长度
            if (pattern.charAt(i) == 'a') {
                if (a == null) {
                    a = value.substring(j, j + aLen);
                } else if (!value.substring(j, j + aLen).equals(a)) {
                    return false;
                }
                j += aLen;
            } else {
                if (b == null) {
                    b = value.substring(j, j + bLen);
                } else if (!value.substring(j, j + bLen).equals(b)) {
                    return false;
                }
                j += bLen;
            }
        }
        return true;
    }
}
