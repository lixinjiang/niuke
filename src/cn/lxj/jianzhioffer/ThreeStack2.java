package cn.lxj.jianzhioffer;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印，递归方法
 */
public class ThreeStack2 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
