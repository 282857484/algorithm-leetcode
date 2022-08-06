package com.leecode.algorithm.middle.evalRPN;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 注意两个整数之间的除法只保留整数部分。
 *
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 就是按照栈进行计算
 */
public class Solution {
    public static void main(String[] args){
        Solution s =new Solution();
        s.evalRPN(new String[]{"4","13","5","/","+"});
    }

    /**
     *
     * @param tokens
     * @return
     */
    public int evalRPN1(String[] tokens) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    stack.push(String.valueOf(Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop())));
                    break;
                case "-":
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(b - a));
                    break;
                case "*":
                    stack.push(String.valueOf(Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop())));
                    break;
                case "/":
                    int c = Integer.valueOf(stack.pop());
                    int d = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(d / c));
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.peek());
    }
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
