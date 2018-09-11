package cn.lxj.treenote;

/**
 * Node
 * description 节点，替代C中的指针
 * create class by lxj 2018/9/10
 **/
public class Node<T extends BaseData> {
    // 节点数据
    T data;
    // 父节点，左右子节点
    Node<T> fatherNode, leftChildNode, rightChildNode;
    // 是否是左节点，是否是右节点
    boolean isLeftChild = false,isRightChild = false;
    // 左节点是否存在
    public boolean haveLeftChild() {
        return !(leftChildNode == null);
    }
    // 右节点是否存在
    public boolean haveRightChild(){
        return !(rightChildNode == null);
    }

    // Construct Method
    public Node(boolean isLeft, boolean isRight) {
        isLeftChild = isLeft;
        isRightChild = isRight;
    }
}