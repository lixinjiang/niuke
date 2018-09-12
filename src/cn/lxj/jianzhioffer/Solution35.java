package cn.lxj.jianzhioffer;

/**
 * Solution35
 * description
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * create class by lxj 2018/9/12
 **/
public class Solution35 {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return InversePairsCore(array, copy, 0, array.length - 1);
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) return 0;
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007) // 数值过大求值
                    count %= 1000000007;
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        System.arraycopy(copy, low, array, low, high + 1 - low);
        return (leftCount + rightCount + count) % 1000000007;
    }

    @Deprecated
    public int InversePairsOld(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    count++;
                }
            }
        }
        return count % 1000000007;
    }
}
