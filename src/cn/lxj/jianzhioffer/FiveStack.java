package cn.lxj.jianzhioffer;

import org.junit.Test;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class FiveStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int size1 = stack1.size();
        for (int i = 0; i < size1; i++) {
            stack2.push(stack1.pop());
        }
        int rs = stack2.pop();
        int size2 = stack2.size();
        for (int j = 0; j < size2; j++) {
            stack1.push(stack2.pop());
        }
        return rs;
    }

    @Test
    public void test1() {
        FiveStack stack = new FiveStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }

    @Test
    public void test2() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("pop value:" + stack.pop() + ",i=" + i);
        }
    }
}
