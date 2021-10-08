package com.leecode.algorithm.middle.zconvert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chararray = s.toCharArray();
        ArrayList<StringBuilder> listlist = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            StringBuilder x = new StringBuilder();
            listlist.add(x);
        }
        boolean down = true;
        int cnt = 1;
        for (int i = 0; i< s.length(); i++) {
            if (down && cnt < numRows) {
                listlist.get(cnt-1).append(chararray[i]);
                cnt ++;
            } else if (down && cnt == numRows) {
                listlist.get(cnt-1).append(chararray[i]);
                cnt --;
                down = false;
            } else if (!down && cnt > 1) {
                listlist.get(cnt-1).append(chararray[i]);
                cnt --;
            } else if (!down && cnt == 1) {
                listlist.get(cnt-1).append(chararray[i]);
                cnt ++;
                down = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(listlist.get(i));
        }
        return result.toString();
    }
}
