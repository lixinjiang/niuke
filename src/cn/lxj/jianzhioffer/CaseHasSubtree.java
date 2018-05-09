package cn.lxj.jianzhioffer;

/**
 * @ClassName CaseHasSubtree
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author lxj
 * @Date 2018/4/17
 **/
public class CaseHasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = AhaseB(root1, root2);
            }
            if (result == false) {
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean AhaseB(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val) {
            return AhaseB(root1.left, root2.left) && AhaseB(root1.right, root2.right);
        }
        return false;
    }
}
