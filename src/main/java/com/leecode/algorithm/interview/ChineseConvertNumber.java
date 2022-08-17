package com.leecode.algorithm.interview;


import java.util.HashMap;

public class ChineseConvertNumber{
    public static void main(String[] args) {
        String chineseNum = "一千二百亿三千四百万五千六百七十八";
        ChineseConvertNumber c= new ChineseConvertNumber();
        Long num = c.chineseConvertNumber(chineseNum);
    }
    public ChineseConvertNumber() {
        nMap.put('零',0L);
        nMap.put('一',1L);
        nMap.put('二',2L);
        nMap.put('三',3L);
        nMap.put('四',4L);
        nMap.put('五',5L);
        nMap.put('六',6L);
        nMap.put('七',7L);
        nMap.put('八',8L);
        nMap.put('九',9L);

        mMap.put('十', 10L);
        mMap.put('百', 100L);
        mMap.put('千', 1000L);
        mMap.put('万', 10000L);
        mMap.put('亿', 100000000L);
        
    }
    HashMap nMap = new HashMap();
    HashMap mMap = new HashMap();
    private Long chineseConvertNumber(String chineseNum) {
        long result = 0L;
        char[] c = chineseNum.toCharArray();
        //处理亿前面的千百十 * 100000000
        if (chineseNum.contains("亿")) {

        }
        //处理万前面的千百十 * 10000 + 上面的部分
        if (chineseNum.contains("万")) {

        }
        //处理万后面的千百十 +上面的部分

        return result;
    }
    
}
