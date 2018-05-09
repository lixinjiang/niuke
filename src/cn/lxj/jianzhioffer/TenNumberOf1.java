package cn.lxj.jianzhioffer;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName TenNumberOf1
 * @Description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @Author lxj
 * @Date 2018/4/17
 **/
public class TenNumberOf1 {
    /**
     * 方法一
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int index = 1;
        int number = 0;
        while (index != 0) {
            if ((n & index) != 0)   // 同为1则为1，其他情况都为0
                number++;           // 将index从右到左进行与运算，说明有多少个1
            index = index << 1;
        }
        return number;
    }

    /**
     * 方法二
     *
     * @param n
     * @return
     */
    public int NumberOf12(int n) {
        int number = 0;
        String string = Integer.toBinaryString(n);
        char[] chars = string.toCharArray();
        int i = 0;
        for (; i < string.length(); i++) {
            if (chars[i] == '1')
                number++;
        }
        return number++;
    }

    @Test
    public void test() {
        System.out.println(NumberOf12(10));
    }
}
