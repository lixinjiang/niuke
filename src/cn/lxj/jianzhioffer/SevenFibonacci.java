package cn.lxj.jianzhioffer;

import org.junit.Test;

/**
 * @ClassName SevenFibonacci
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * @Author lxj
 * @Date 2018/4/17
 **/
public class SevenFibonacci {
    public int Fibnoacci(int i) {
        // 使用递归解法
        if (i == 2 || i == 1) {
            return 1;
        } else if (i <= 0) {
            return 0;
        } else {
            return Fibnoacci(i - 1) + Fibnoacci(i - 2);
        }
    }

    @Test
    public void test() {
        System.out.println(Fibnoacci(40));
    }
}
