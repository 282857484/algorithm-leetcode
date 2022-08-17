package com.leecode.algorithm.interview;

public class NumberConverChinese {
    public static void main(String[] args) {
        NumberConverChinese m = new NumberConverChinese();
        System.out.println(m.numberConverChinese(9100300091L));
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
        char[] unProcess = chinese.reverse().toString().toCharArray();

        // 多个零合并为一个零（零的单位也删除）
        convertZero(unProcess);
        // 去掉空格
        int end = convertN(unProcess);
        return (new String(unProcess).substring(0, end)).trim();
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
                return "十";
            case 6:
                return "百";
            case 7:
                return "千";
            case 8:
                return "亿";
            case 9:
                return "十";
            case 10:
                return "百";
            case 11:
                return "千";
        }
        return "";
    }

    /**
     * 去掉零后面的单位与相邻零
     * 这个方法有问题
     */
    public void convertZero(char[] a) {
        boolean zeroLeader = false;
        for (int i = 0; i < a.length; i=i+2) {
            // 合并零
            if (zeroLeader) {
                if (a[i] == '零') {
                    a[i] = ' ';
                } else {
                    zeroLeader = false;
                }
            } else {
                if (a[i] == '零') {
                    zeroLeader = true;
                }
            }
            if ((i+1) < a.length && zeroLeader && (a[i+1] == '千' || a[i+1] == '百' || a[i+1] == '十')) {
                a[i+1] = ' ';
            }
            // 万、亿单独去零
            if ((i+1) < a.length && (a[i+1] == '万' || a[i+1] == '亿')) {
                if (a[i] == '零') {
                    a[i] = ' ';
                }
            }
        }
    }
    //去掉空格
    public int convertN(char[] a) {
        int slow = 0;
        for (int quick = 0; quick < a.length; quick++) {
            if (a[quick] == ' ') {

            } else {
                a[slow] = a[quick];
                slow++;
            }
        }
        return slow;
    }
}