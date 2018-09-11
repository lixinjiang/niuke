package cn.lxj.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution22
 * description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * create by lxj 2018/9/6
 **/
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        // 通过一个队列保存二叉树节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            // 如果队列不为空，取出队列首的一个节点，进行打印。
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}