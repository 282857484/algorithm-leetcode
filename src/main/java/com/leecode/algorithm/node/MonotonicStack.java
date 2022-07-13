package com.leecode.algorithm.node;

import java.util.Stack;

/**
 * 单调栈
 */
class MonotonicStack<T extends Comparable> {
    public Stack<T> stack;

    public MonotonicStack() {
        this.stack = new Stack<T>();
    }

    /**
     * 单调栈方法压入元素
     * 相同元素会放入最新数据
     * @param t
     * @return
     */
    public T push(T t) {
        while (true) {
            if (stack.empty()) {
                stack.push(t);
                break;
            }
            if (stack.lastElement().compareTo(t) <= 0) {
                stack.pop();
            } else {
                stack.push(t);
                break;
            }
        }
        return t;
    }
}
