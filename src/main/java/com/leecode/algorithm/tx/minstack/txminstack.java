package com.leecode.algorithm.tx.minstack;

public class txminstack {

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        ms.getMin();
        ms.pop();
        ms.top();
        ms.getMin();
    }
}
