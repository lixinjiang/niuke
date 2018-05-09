package cn.lxj.jianzhioffer;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName CaseFindKthToTail
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 * @Author lxj
 * @Date 2018/4/17
 **/
public class CaseFindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        if(head == null){
            return null;
        }else{
            while (head != null) {
                stack.push(head);
                head = head.next;
            }
            if(stack.size() < k){
                return null;
            }else{
                ListNode node = null;
                for(int i = 0;i < k;i ++){
                    node = stack.pop();
                }
                return node;
            }
        }
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(FindKthToTail(listNode, 4));
    }
}