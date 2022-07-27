package com.leecode.algorithm.middle.longestPalindrome;

public class Solution6 {

    // manachar方法 马拉车
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 将s转换为加了特殊字符#的字符数组，目的是统一奇偶数的回文中心差异性问题
        // 比如：s=”cabac“转化为cs=[#c#a#b#a#c#]
        char[] cs = manacherString(s, len);
        // pArr[i]是cs[i]每个位置的最大回文半径
        // 比如：cs=[#c#a#b#a#c#]，pArr=[1,2,1,2,1,6,1,2,1,2,1]
        int[] pArr = new int[cs.length];
        // right是cs[i]每个位置的回文右边界（水位线）的下一个位置
        // 比如：cs=[#c#a#b#a#c#]，right=1,3,3,5,5,11(此时right第一次遍历完cs，之后的right可以不再更新),11,11,11,11,11
        int right = -1;
        // index是最近更新right时的回文中心位置
        // 比如：cs=[#c#a#b#a#c#]，index=0,1,1,3,3,5(之后right不再更新，index也不再更新),5,5,5,5,5
        int index = -1;
        for (int i = 0; i != cs.length; i++) {
            // 第一句代码:每轮循环时,i至少不需要验证的区域,先给到pArr[i],解释如下:
            // right<=i:i超过了right，无法优化，不用验证的区域就是pArr[i]本事=回文半径为1
            // right>i:i没有超过right，可以优化，至少不需要验证的区域：Math.min(pArr[2 * index - i], right - i)
            // 以index为中心i的对称点是(2*index-i)
            pArr[i] = right > i ? Math.min(pArr[2 * index - i], right - i) : 1;
            // 第二句代码:在i位置尝试往外扩最长回文半径长度pArr[i]:
            // 如果扩成功pArr[i]++;否则立刻停止扩的过程break
            while (i + pArr[i] < cs.length && i - pArr[i] >= 0) {
                if (cs[i + pArr[i]] == cs[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            // 每轮循环,扩的长度超过回文右边界下一个位置，就更新right和index
            if (i + pArr[i] > right) {
                right = i + pArr[i];
                index = i;
            }
        }

        // max记录pArr[i]中最大值：pArr[i]最大值就能算出原字符串的最长回文子串长度
        int maxLen = Integer.MIN_VALUE;
        int centerIndex = Integer.MIN_VALUE;
        // 找出cs中回文半径最大值maxLen和其对应的数组索引centerInter
        for (int i = 0; i < cs.length; i++) {
            if (pArr[i] > maxLen) {
                maxLen = pArr[i];
                centerIndex = i;
            }
        }
        // 根据cs中回文半径和对应坐标算原字符串中的最大回文长度和最大回文中心
        // 原字符串最大回文长度：maxLen-1，比如#a#b#a#，b的回文半径=4，那么原aba的最长回文子串长度为3
        maxLen = maxLen - 1;
        // 原字符串最大回文串中心：(centerIndex - 1)/2，比如#a#b#a#，b的centerIndex=4；那么原aba的b的坐标为(4-1)/2
        centerIndex = (centerIndex - 1) / 2;
        // 根据centerIndex和maxLen算最大回文串begin下标
        // 奇数：centerIndex-maxLen/2
        // 偶数：centerIndex-maxLen/2+1
        // 统一：centerIndex-(maxLen-1)/2
        int begin = 0;
        begin = centerIndex - (maxLen - 1) / 2;
        return s.substring(begin, begin + maxLen);
    }

    // 将str转换成带#号的字符数组:解决奇数、偶数中心往外扩的差异性
    public static char[] manacherString(String s, int n) {
        char[] charArr = s.toCharArray();
        int index = 0;// index遍历charArr
        // s:a -> res:#a#，长度1 -> 3，奇数位放#，偶数位放原字符
        // s:ab -> res:#a#b#，长度2 -> 5，奇数位放#，偶数位放原字符
        // s:aba -> res:#a#b#a#，长度3 -> 7，奇数位放#，偶数位放原字符
        // 长度变化规律:len -> len+len+1=len*2+1，奇数位放#，偶数位放原字符
        char[] res = new char[n * 2 + 1];
        for (int i = 0; i != res.length; i++) {
            // 偶数位放#，奇数位放原字符
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

}