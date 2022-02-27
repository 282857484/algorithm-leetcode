package  com.leecode.algorithm.easy.CQueue;

import java.util.Stack;

// 剑指 Offer 09. 用两个栈实现队列
class CQueue {
    Stack<Integer> out;
    Stack<Integer> in;

    public CQueue() {
        out = new Stack();
        in = new Stack();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        if (out.empty()){
            return -1;
        }
        return out.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
