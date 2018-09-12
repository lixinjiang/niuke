package cn.lxj.jianzhioffer;

/**
 * Solution36
 * description
 * 输入两个链表，找出它们的第一个公共结点。
 * 应该是值相等就行
 * create class by lxj 2018/9/12
 **/
public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int count1 = 0;
        ListNode p1 = pHead1;
        while (p1 != null) {
            p1 = p1.next;
            count1++;
        }
        int count2 = 0;
        ListNode p2 = pHead2;
        while (p2 != null) {
            p2 = p2.next;
            count2++;
        }
        int flag = count1 - count2;
        if (flag > 0) {
            while (flag > 0) {
                pHead1 = pHead1.next;
                flag--;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        while (flag < 0) {
            pHead2 = pHead2.next;
            flag++;
        }
        while (pHead1 != pHead2) {
            pHead2 = pHead2.next;
            pHead1 = pHead1.next;
        }
        return pHead1;
    }
}
