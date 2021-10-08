package com.leecode.algorithm.tx.minstack;

import java.util.LinkedList;
import java.util.Stack;

class MinStack {

    Stack<Integer> stack = null;
    // 从大到小
    LinkedList<Integer> minlist = null;

    public MinStack() {
        stack = new Stack<>();
        minlist = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minlist.size() == 0){
            minlist.add(val);
        } else {
            if (minlist.getLast() >= val) {
                minlist.addLast(val);
            } else {
                for (int i = 0; i < minlist.size(); i++) {
                    if (minlist.get(i) <= val) {
                        minlist.add(i, val);
                        break;
                    }
                }
            }
        }
    }

    public void pop() {
        Integer val = stack.pop();
        for (int i = 0; i < minlist.size(); i++) {
            if (val.compareTo(minlist.get(i)) == 0){
                minlist.remove(i);
                break;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minlist.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */