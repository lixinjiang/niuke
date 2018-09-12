package cn.lxj.jianzhioffer;

/**
 * Solution38
 * description
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * create class by lxj 2018/9/12
 **/
public class Solution38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int rs = Math.max(left,right) + 1;
        return rs;
    }
}
