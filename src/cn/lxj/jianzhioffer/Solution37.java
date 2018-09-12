package cn.lxj.jianzhioffer;

/**
 * Solution37
 * description
 * 统计一个数字在排序数组中出现的次数。
 * create class by lxj 2018/9/12
 **/
public class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null)
            return 0;
        int count = 0;
        for (int a : array) {
            if (a == k) count++;
        }
        return count;
    }
}
