package cn.lxj.jianzhioffer;

import org.junit.Test;

/**
 * Solution31
 * description
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * create class by lxj 2018/9/11
 **/
public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1')
                    count++;
            }
            n--;
        }
        return count;
    }

    @Test
    public void soutBinaryString() {
        int[] array = {1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        for (int a : array)
            System.out.println(Integer.toBinaryString(a));
    }

    // 首先在jvm中一个int类型的数据占4个字节，共32位，其实就相当于一个长度为32的数组。
    // 那我们要计算首部0的个数，就是从左边第一个位开始累加0的个数，直到遇到一个非零值。
    @Test
    public void numberOfLeadingZeros(int i) {
        if (i == 0)
            System.out.println(32);
        System.out.println("31:" + Integer.toBinaryString(i));
        System.out.println("16:" + Integer.toBinaryString(16));
        System.out.println("24:" + Integer.toBinaryString(24));
        System.out.println("28:" + Integer.toBinaryString(28));
        System.out.println("30:" + Integer.toBinaryString(30));

        int n = 1;
        // 下面的代码就是定位从左边开始第一个非零值的位置，在定位过程中顺便累加从左边开始0的个数
        // 将i无符号右移16位后，有二种情况；
        //   情况1.i=0,则第一个非零值位于低16位，i至少有16个0，同时将i左移16位（把低16位移到原高16位的位置，这样情况1和情况2就能统一后续的判断方式）
        //   情况2.i!=0,则第一个非零值位于高16位，后续在高16位中继续判断
        // 这个思路就是二分查找，首先把32位的数分为高低16位，如果非零值位于高16位，后续再将高16位继续二分为高低8位，一直二分到集合中只有1个元素
        if (i >>> 16 == 0) {
            n += 16;
            i <<= 16;
            System.out.println("i左移16位：" + Integer.toBinaryString(i));
        }
        // 判断第一个非零值是否位于高8位
        if (i >>> 24 == 0) {
            n += 8;
            i <<= 8;
            System.out.println("i左移8位：" + Integer.toBinaryString(i));
        }
        // 判断第一个非零值是否位于高4位
        if (i >>> 28 == 0) {
            n += 4;
            i <<= 4;
            System.out.println("i左移4位：" + Integer.toBinaryString(i));
        }
        // 判断第一个非零值是否位于高2位
        if (i >>> 30 == 0) {
            n += 2;
            i <<= 2;
            System.out.println("i左移2位：" + Integer.toBinaryString(i));
        }
        // 判断第一个非零值是否位于左边第一位
        n -= i >>> 31;
        System.out.println(n);
    }
}
