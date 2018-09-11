package cn.lxj.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Solution29
 * description
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * create class by lxj 2018/9/11
 **/
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> rs = new ArrayList<>();
        if (input.length < k || input.length == 0) return rs;
        // 升序
        Arrays.sort(input);
        Stack<Integer> stack = new Stack<>();
        for (int i = input.length -1; i >= 0; i--) {
            stack.push(input[i]);
        }
        for (int i = 0; i < k; i++) {
            rs.add(stack.pop());
        }
        return rs;
    }
}
