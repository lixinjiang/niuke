package cn.lxj.jianzhioffer;

import org.junit.Test;

import static java.lang.Math.abs;

/**
 * @ClassName ElePower
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @Author lxj
 * @Date 2018/4/17
 **/
public class ElePower {
    /**
     * 方法一
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        // 浮点数，整形
        return Math.pow(base, exponent);
    }

    /**
     * 方法二
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
        double result = 1;//这里一定要写成1，因为result是乘法的基础，不是加减
        if (exponent == 0)
            return 1;
        int absExponent = abs(exponent);
        for (int i = 0; i < absExponent; i++)
            result *= base;
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    @Test
    public void test() {
//        System.out.println(Power(2, 3));
//        System.out.println(Power2(2,3));
        System.out.println(Integer.toString(36,36));

    }
}
