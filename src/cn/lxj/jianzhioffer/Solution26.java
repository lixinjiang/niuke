package cn.lxj.jianzhioffer;

/**
 * Solution26
 * description
 * <p>输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。</p>
 * create class by lxj 2018/9/10
 **/
public class Solution26 {
    // 采用中序遍历后的节点是有序的，所以采用的遍历顺序应该是中序的
    public TreeNode Convert(TreeNode pRootOfTree) {// 根节点？
        TreeNode lastNode = null;
        TreeNode headNode = ConvertNode(pRootOfTree,lastNode);
        while (headNode != null && headNode.left != null)
            headNode = headNode.left;
        return headNode;
    }

    public TreeNode ConvertNode(TreeNode rootTree,TreeNode lastNode){
        if (rootTree == null)
            return null;
        if (rootTree.left != null)//一直找到最左节点
            lastNode = ConvertNode(rootTree.left, lastNode);
        rootTree.left = lastNode;
        if (lastNode != null)
            lastNode.right = rootTree;
        lastNode = rootTree;
        if (rootTree.right!=null)
            lastNode = ConvertNode(rootTree.right, lastNode);
        return lastNode;
    }
}