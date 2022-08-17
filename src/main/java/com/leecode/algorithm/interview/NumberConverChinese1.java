package com.leecode.algorithm.interview;

public class NumberConverChinese1 {
    public static void main(String[] args) {
        NumberConverChinese1 m = new NumberConverChinese1();
        System.out.println(m.num2cn(2100300091));
    }
    String[] weight = new String[]{"","万","亿"};
    String[] number = new String[3];
    String[] pos = new String[]{"","十","百","千"};
    String[] digits = new String[]{"零","一","二","三","四","五","六","七","八","九"};
    public String num2cn(int n) {
        // write code here
        if (n == 0)
            return "零";
        StringBuilder ans = new StringBuilder();
        int cur = n;
        if (n < 0) {
            ans.append('负');
            cur = -cur;
        }


        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            if (!getNumber(cur % 10000).equals("零"))
                sb.append(weight[count]);
            count++;
            sb.append(getNumber(cur % 10000));

            cur /= 10000;
        }
        sb.reverse();
        char[] cs = sb.toString().toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if ((i == 0 || cs[i - 1] == '零') && cs[i] == '零')
                continue;
            ans.append(cs[i]);
        }
        while (ans.charAt(ans.length() - 1) == '零')
            ans.deleteCharAt(ans.length() - 1);
        return ans.toString();

    }
    private String getNumber(int cur) {
        if (cur == 0)
            return "零";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (cur % 10 != 0)
                sb.append(pos[i]);
            if (!(i == 1 && cur == 1 ))
                sb.append(digits[cur % 10]);
            cur /= 10;
        }
        while (sb.length() > 0 && sb.charAt(0) == '零')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}