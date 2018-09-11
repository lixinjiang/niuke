package cn.lxj.jianzhioffer;

import java.util.HashMap;

/**
 * Solution28
 * description
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * create class by lxj 2018/9/11
 **/
public class Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        double halfSize = array.length / 2.0;
        System.out.println("halfSize：" + halfSize);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : array) {
            if (map.containsKey(a))
                map.put(a,map.get(a) + 1);
            else {
                map.put(a,1);
            }
            if (map.get(a) > halfSize) return a;
        }
        return 0;
    }
}
