package cn.lxj.jianzhioffer;

import java.util.Iterator;
import java.util.Stack;

/**
 * Solution2    运行时间：20ms
                占用内存：9176k
 * description TODO
 * create by lxj 2018/9/6
 **/
public class Solution2 {
    private Stack<Integer> stack = new Stack<>();

    public void push(int node){// 进栈
        stack.push(node);
    }

    public void pop() {// 出栈
        stack.pop();
    }

    public int top() {// 取得栈顶值
        return stack.peek();
    }
    // find min value
    public int min() { // 取得最小值
        int min = stack.peek();
        Iterator<Integer> iterator = stack.iterator();
        int tem;
        while (iterator.hasNext()) {
            tem = iterator.next();
            if (min > tem) {
                min = tem;
            }
        }
        return min;
    }
}
