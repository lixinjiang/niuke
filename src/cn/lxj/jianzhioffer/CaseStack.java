package cn.lxj.jianzhioffer;

import org.junit.Test;

import java.util.Stack;

/**
 * CaseStack
 * description 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * create by lxj 2018/4/18
 **/
public class CaseStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    Integer tem = null;

    public void push(int node) {
        if (tem != null) {
            if (node < tem) {
                tem = node;
                stack1.push(node);
                stack2.push(node);
            } else {
                stack1.push(node);
                stack2.push(tem);
            }
        } else {
            tem = node;
            stack1.push(node);
            stack2.push(node);
        }

    }

    public void pop() {
        if (!stack1.empty() && !stack2.empty()) {
            int m = stack1.pop();
            stack2.pop();
            tem = m;
        }
    }

    public int top() {
        int top = stack1.pop();
        stack1.push(top);
        return top;
    }

    /**
     * 得到栈最小元素
     *
     * @return
     */
    public int min() {
        int min = stack2.peek();
        return min;
    }

    @Test
    public void test() {
        CaseStack caseStack = new CaseStack();
        caseStack.push(1);
        caseStack.push(2);
        caseStack.push(3);
        caseStack.push(4);
        caseStack.push(5);
        caseStack.push(6);
        System.out.println(caseStack.min());
        System.out.println(caseStack.min());
        System.out.println(caseStack.min());
    }

}