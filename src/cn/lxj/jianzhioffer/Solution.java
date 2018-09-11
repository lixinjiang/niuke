package cn.lxj.jianzhioffer;

import java.util.Stack;

/**
 * Solution 运行时间：22ms
            占用内存：9100k
 * description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1）
 * create by lxj 2018/9/4
 **/
public class Solution {
    private Stack<Integer> data_stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();

    public void push(int node){// 进栈，保持min_stack栈顶最小
        if (min_stack.isEmpty() || min_stack.peek() >= node) {
            min_stack.push(node);
        } else {
            min_stack.push(min_stack.peek());
        }
        data_stack.push(node);
    }

    public void pop() {// 出栈
        if (data_stack.empty() || min_stack.empty()) return;
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {// 取得栈顶值
        if (!data_stack.empty()) {
            return data_stack.peek();
        }
        return 0;
    }
    // find min value
    public int min() { // 取得最小值
        if (!min_stack.empty()) {
            return min_stack.peek();
        }
        return 0;
    }

}
