package cn.lxj.jianzhioffer;

import java.util.ArrayList;

/**
 * Solution24
 * description  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * <p>
 * ideal
 * 1.路径的定义：从树的根节点往下，一直到叶节点
 * 2.树的遍历
 * 3.路径的保存：每次找到路径之后，应将路径保存到ArrayList<ArrayList<Integer>> result中，最终打印全部路径
 * <p>
 * notice：
 * 判断树是否为null，是否只有根节点
 * 用前序遍历方法，可以首先访问节点，然后将节点入队列（或栈均可），并将数值和之前入队的总和num相加
 * 判断当前值之和是否满足给定的值，判断当前节点是否叶节点。若当前值等于给定值，且当前节点是叶节点，则打印路径信息；若当前值小于给定值，且当前节点不是叶节点，
 * 则递归调用该节点的左右子树；若当前值大于给定值，无需递归（在默认节点值为正的情况下）
 * create by lxj 2018/9/6
 **/
public class Solution24 {
    // 使用递归解决，绕
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    // 数组套数组
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return list;
        // 每访问一个节点的时候，都把当前节点添加到路径中去，并调整target的值
        path.add(root.val);
        target -= root.val;

        // 已到叶节点，并且和为target，则把当前路径添加到输出列表里
        // 因为add添加的是引用，如果不new一个的话，最终list保存到的只是最后一个path
        if (target == 0 && root.left == null && root.right == null)
            list.add(new ArrayList<Integer>(path));

        // 否则继续遍历
        FindPath(root.left, target);
        FindPath(root.right, target);

        // 已到叶节点之后会跳过两个递归函数到这里，此时要把最后一个节点从路径中删除，才能返回上一个节点
        path.remove(path.size() - 1);
        return list;
    }
}