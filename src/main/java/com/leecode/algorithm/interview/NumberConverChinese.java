package com.leecode.algorithm.interview;

public class NumberConverChinese {
    public static void main(String[] args) {
        System.out.println("hello world");
        NumberConverChinese m = new NumberConverChinese();
        m.numberConverChinese(9187340091L);
    }
    public String numberConverChinese(long a) {
        long n = 0;
        int m = 0;
        StringBuilder chinese = new StringBuilder();
        while(a != 0) {
            n = a%10;
            a = a/10;
            // 添加单位
            chinese.append(convertX(m));
            // 添加数字
            chinese.append(convert(n));
            m++;
        }
        char[] unProcess = chinese.toString().toCharArray();
        int l = 0;
        int r = unProcess.length-1;
        // 翻转字符串
        while(l<r) {
            char tmp = unProcess[l];
            unProcess[l] = unProcess[r];
            unProcess[r] = tmp;
            l++;
            r--;
        }

        // 多个零合并为一个零（单位也删除） 可以用快慢指针合并
        convertZero(unProcess);
        // 去掉空格
        convertN(unProcess);
        return (new String(unProcess)).trim();
    }
    public String convert(long n) {
        switch((int)n){
            case 0:
                return "零";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
        }
        return "";
    }
    public String convertX(int m) {
        switch(m){
            case 0:
                return " ";
            case 1:
                return "十";
            case 2:
                return "百";
            case 3:
                return "千";
            case 4:
                return "万";
            case 5:
                return " ";
            case 6:
                return "十";
            case 7:
                return "百";
            case 8:
                return "千";
            case 9:
                return "亿";
            case 10:
                return " ";
            case 11:
                return "十";
            case 12:
                return "百";
            case 13:
                return "千";
        }
        return "";
    }

    /**
     slowindex
     */
    public int convertZero(char[] a) {
        int slow = 0;
        for (int quick = 1; quick < a.length; quick+=2) {
            if (a[quick] != '零') {
                a[slow] = a[quick];
                slow++;
                a[slow+1] = a[quick+1];
                slow++;
            }
        }
        return slow;
    }
    //去掉空格
    public int convertN(char[] a) {
        int slow = 0;
        for (int quick = 1; quick < a.length; quick++) {
            if (a[quick] != ' ') {
                a[slow] = a[quick];
                slow++;
            }
        }
        return slow;
    }
}