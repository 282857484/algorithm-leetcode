package com.leecode.algorithm.easy.isValid;

import java.util.Stack;

class Solution {
    Stack<Integer> stack = new Stack<>();
    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            Integer ss = Integer.valueOf(s.charAt(i));
            if (stack.empty()) {
                if (ss == '[' || ss == '(' || ss == '{' ) {
                    stack.push(ss);
                } else {
                    return false;
                }
            } else {
                if (ss == '[' || ss == '(' || ss == '{' ) {
                    stack.push(ss);
                } else if (ss == ']' ) {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }else if (ss == ')' ) {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }else if (ss == '}' ) {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        if (stack.empty()){
            return true;
        } else {
            return false;
        }
    }
}
