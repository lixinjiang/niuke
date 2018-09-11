package cn.lxj.test;

import cn.lxj.jianzhioffer.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * TestSolution
 * description 测试栈数据结构找到最小的元素的min函数
 * create by lxj 2018/9/4
 **/
public class TestSolution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        Solution2 solution = new Solution2();
        solution.push(1);
        solution.push(100);
        solution.push(58);
        solution.push(44);
        solution.push(66);
        solution.push(-1);
        System.out.println(solution.min());
    }

    @Test
    public void testSolution21() {
        Solution21 solution21 = new Solution21();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(solution21.IsPopOrder(pushA, popA));
    }

    @Test
    public void testSolution24() {
        Solution24 solution = new Solution24();
        TreeNode root = new TreeNode(100);
//        root.
    }

    @Test
    public void testSolution27() {
        Solution27 solution = new Solution27();
        String str = "abc";
        ArrayList<String> permutation = solution.Permutation(str);
        System.out.println(permutation.size());
        for (String s : permutation) {
            System.out.println(s);
        }
    }
}
