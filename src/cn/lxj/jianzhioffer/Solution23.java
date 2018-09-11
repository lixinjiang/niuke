package cn.lxj.jianzhioffer;

import java.util.Arrays;

/**
 * Solution23
 * description  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * create by lxj 2018/9/6
 **/
public class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int len = sequence.length; // 节点个数
        int root = sequence[len - 1];// 根节点
        int i = 0;
        for (; i < len - 1; i++) {// 循环，判断除了节点与根节点大小的比较，直到找到大于根节点的值
            if (root <= sequence[i])
                break;
        }
        int j = i;
        for (; j < len - 1; j++) {// 循环，判断除了节点与根节点大小的比较，如果没有右节点，则返回false
            if (root > sequence[j])
                return false;
        }
        boolean leftFlag = true;
        if (i > 0) {
            leftFlag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i)); // 递归左节点
        }
        boolean rightFlag = true;
        if (i < len - 1) {
            rightFlag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1)); // 递归右节点
        }
        return leftFlag && rightFlag;
    }
}