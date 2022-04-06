package com.leecode.algorithm.easy;

import java.util.Arrays;
import java.util.Collections;

public class reverseString {

    public static void main(String[] args) {
        reverseString r = new reverseString();
        System.out.println(r.reverseString("致一据数证保何如lqsyM和sideR"));
    }
    public String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
