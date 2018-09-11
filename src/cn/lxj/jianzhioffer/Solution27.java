package cn.lxj.jianzhioffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Solution27
 * description
 * 解题思路：
 * 1、列出所有字符串用递归求解
 * 2、按照字典顺序输出，这就用到强大的TreeSet了，直接排好序。
 * <p>输入一个字符串,按字典序打印出该字符串中字符的所有排列。</p>
 * <p>例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。</p>
 * create class by lxj 2018/9/11
 **/
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> res = new TreeSet<>(); // 用于排列输出
        getResult(chars, 0, str.length() - 1, res);
        result.addAll(res);
        return result;
    }

    private void getResult(char[] chars, int start, int end, TreeSet<String> res) {// 开始start=0，end是索引
        if (start == end) {
            res.add(String.valueOf(chars));
        } else {
            for (int i = start; i <= end; i++) {
                swap(chars, start, i); // 换一位
                getResult(chars, start + 1, end, res); // 递归
                swap(chars, start, i); // 换回来，保证下次换位是正确的
            }
        }
    }

    private void swap(char[] chars, int a, int b) {
        if (a != b) {
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }
    }
}