package cn.lxj.test;

import cn.lxj.jianzhioffer.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * TestSolution
 * description
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

    @Test
    public void testSolution28() {
        Solution28 solution = new Solution28();
        int[] array = {5, 5, 5, 5, 5, 5, 5, 4, 2};
        System.out.println(array.length);
        int rs = solution.MoreThanHalfNum_Solution(array);
        System.out.println("超过一半的数是：" + rs);
    }

    @Test
    public void testSolution29() {
        Solution29 solution = new Solution29();
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> integers = solution.GetLeastNumbers_Solution(array, 3);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    @Test
    public void testSolution30() {
        Solution30 solution = new Solution30();
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        int rs = solution.FindGreatestSumOfSubArray(array);
        System.out.println("最大一维连续值是：" + rs);
    }

    @Test
    public void testSolution31() {
        Solution31 solution = new Solution31();
        int rs = solution.NumberOf1Between1AndN_Solution(1300);
        System.out.println(rs);
    }

    @Test
    public void testSolution32() {
        Solution32 solution = new Solution32();
        int[] numbersArray = {12, 41, 345};
        String s = solution.PrintMinNumber(numbersArray);
        System.out.println(s);
    }

    @Test
    public void testSolution33() {
        Solution33 solution = new Solution33();
        int uglyNumber = solution.GetUglyNumber_Solution(7);
        System.out.println(uglyNumber);
        System.out.println(Integer.toBinaryString(uglyNumber));
        System.out.println(Integer.numberOfLeadingZeros(uglyNumber));
        int pow = (int) Math.pow(2, 32);
        System.out.println(pow + ":" + Integer.toBinaryString(pow));
    }

    @Test
    public void testSolution34() {
        Solution34 solution = new Solution34();
        int index = solution.FirstNotRepeatingChar("googgle");
        System.out.println(index);
    }
}