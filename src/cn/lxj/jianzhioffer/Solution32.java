package cn.lxj.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution32
 * description
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * create class by lxj 2018/9/12
 **/
public class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        List<String> res = new ArrayList<>();
        getResult(numbers, 0, numbers.length - 1, res);
        Collections.sort(res);
        return res.get(0);
    }

    private void getResult(int[] ints, int start, int end, List<String> res) {
        if (start == end) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                value.append(ints[i]);
            }
            res.add(value.toString());
        } else {
            for (int i = start; i <= end; i++) {
                swap(ints, start, i);
                getResult(ints, start + 1, end, res);
                swap(ints, start, i);
            }
        }
    }

    private void swap(int[] ints, int a, int b) {
        if (a != b) {
            int temp = ints[a];
            ints[a] = ints[b];
            ints[b] = temp;
        }
    }
}
