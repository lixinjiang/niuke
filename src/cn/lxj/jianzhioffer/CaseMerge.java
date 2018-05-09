package cn.lxj.jianzhioffer;

/**
 * @ClassName CaseMerge
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Author lxj
 * @Date 2018/4/17
 **/
public class CaseMerge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            head = list1;
            head.next = Merge(list1.next, list2);
        } else {
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
    }
}
