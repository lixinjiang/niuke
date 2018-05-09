package cn.lxj.jianzhioffer;

import static com.sun.org.apache.bcel.internal.generic.Type.NULL;

/**
 * CasemMirror
 * description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：
 * 源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5   7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11  9 7  5
 * create by lxj 2018/4/17
 **/
public class CaseMirror {
    public void Mirror(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tem = root.left;
            root.left = root.right;
            root.right = tem;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
