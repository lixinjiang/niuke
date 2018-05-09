package cn.lxj.jianzhioffer;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName CaseReverseList
 * @Description 输入一个链表，反转链表后，输出链表的所有元素。
 * @Author lxj
 * @Date 2018/4/17
 **/
public class CaseReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode newhead = stack.pop();       //指针node
        ListNode resulthead = newhead;
        while (!stack.isEmpty()) {
            newhead.next = stack.pop();
            newhead = newhead.next;
        }
        newhead.next = null;

        return resulthead;
    }

    public ListNode ReverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;       // 持有下一个节点的引用
            head.next = pre;        // 将当前节点对下一个节点的引用指向前一个节点
            pre = head;             // 将前一个节点指向当前节点
            head = next;            // 将当前节点指向下一个节点
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = ReverseList(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
