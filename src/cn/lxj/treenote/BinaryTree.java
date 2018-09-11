package cn.lxj.treenote;

/**
 * BinaryTree
 * description 二叉查找树
 * create class by lxj 2018/9/10
 **/
public class BinaryTree<T extends BaseData> {
    // 根节点
    private Node<T> treeRoot;

    /**
     * 构造方法
     */
    public BinaryTree() {
        treeRoot = new Node<T>(false, false);
    }

    /**
     * 从某个节点开始搜索
     *
     * @param target    待搜索数组
     * @param startNode 目标值
     * @return 开始搜索的节点
     */
    public Node searchNode(T target, Node startNode) {
        int compareResult = target.compareTo(startNode.data);

        if (compareResult == 1)
            return startNode;
        else if (compareResult > 0 && startNode.rightChildNode != null) // 比目标值大，并且目标值右节点存在，则递归查找
            return searchNode(target, startNode.rightChildNode);
        else if (compareResult < 0 && startNode.leftChildNode != null)  // 比目标值小，并且目标值左节点存在，则递归查找
            return searchNode(target, startNode.leftChildNode);
        else
            return null;
    }

    /**
     * 查找数据所在节点
     *
     * @param target 目标数据
     * @return null或数据所在节点
     */
    public Node searchNode(T target) {
        if (treeRoot.data == null)
            return null;
        return searchNode(target, treeRoot);
    }

    /**
     * 查找数据
     *
     * @param target 目标数据(有部分检索需要的信息即可)
     * @return 完整目标数据
     */
    public BaseData searchData(T target) {
        Node node = searchNode(target);
        if (node != null)
            return node.data;
        return null;
    }

    /**
     * 插入节点，从最顶层往下，层层对比然后插入
     * @param insertData 比对节点
     * @param node  被比对节点
     */
    private void insertNode(T insertData, Node<T> node) {
        int compareResult = insertData.compareTo(node.data);
        if (compareResult == 0) // 相等
            return;
        else if (compareResult > 0) {// 大于节点值
            if (node.rightChildNode == null) {
                node.rightChildNode = new Node<T>(false, true);
                node.rightChildNode.data = insertData; // 插入值
                node.rightChildNode.fatherNode = node;
                return;
            } else
                insertNode(insertData, node.rightChildNode); // 继续比对右节点的值
        } else { // 小于节点值
            if (node.leftChildNode == null) {
                node.leftChildNode = new Node<T>(true, false);
                node.leftChildNode.data = insertData; // 插入值
                node.leftChildNode.fatherNode = node;
                return;
            } else
                insertNode(insertData, node.leftChildNode); // 继续比对左子节点
        }
    }

    /**
     * 插入节点
     *
     * @param insertNode 带插入的数据
     */
    public void insertNode(T insertNode) {
        if (treeRoot.data == null) {
            treeRoot.data = insertNode;
            return;
        }
        insertNode(insertNode, treeRoot);
    }

    /**
     * 删除节点
     *
     * @param node 待删除节点
     */
    private void deleteNode(Node node) {
        // 如果按顺序排列好节点，它的前驱和后继就是这个序列上紧挨着它左右两侧的节点.

        // 如果节点只有左节点或者只有右节点
        if (node.haveLeftChild() && !node.haveRightChild()) { // 只有左节点
            if (node.isLeftChild) {
                node.fatherNode.leftChildNode = node.leftChildNode;
            } else if (node.isRightChild) {
                node.fatherNode.rightChildNode = node.leftChildNode;
            } else // 待删除节点是根节点
                treeRoot = node.leftChildNode;
            node.leftChildNode.fatherNode = node.fatherNode;
        } else if (node.haveRightChild() && !node.haveLeftChild()) {// 只有右节点
            if (node.isLeftChild) {
                node.fatherNode.rightChildNode = node.rightChildNode;
            } else if (node.isRightChild) {
                node.fatherNode.leftChildNode = node.rightChildNode;
            } else // 待删除节点是根节点
                treeRoot = node.rightChildNode;
            node.rightChildNode.fatherNode = node.fatherNode;
        } else if (node.haveLeftChild() && node.haveRightChild()) { // 有左右子节点
            Node successorNode = getSuccessorNode(node);
            if (successorNode == node.rightChildNode) { // 后继节点是右子节点
                successorNode.fatherNode = node.fatherNode;
                if (node.isLeftChild) {
                    node.fatherNode.leftChildNode = successorNode;
                } else if (node.isRightChild) {
                    node.fatherNode.rightChildNode = successorNode;
                } else { // 根节点
                    successorNode = treeRoot;
                }
                successorNode.fatherNode = node.fatherNode;
                successorNode.leftChildNode = node.leftChildNode;
                node.leftChildNode.fatherNode = successorNode;
            } else { // 后继节点是右子节点的最左子节点
                if (successorNode.haveRightChild()) { // 左子节点有右子树
                    successorNode.fatherNode.leftChildNode = successorNode.rightChildNode;
                    successorNode.rightChildNode.fatherNode = successorNode.fatherNode;

                    replaceNode(node, successorNode);
                } else {// 左子节点没有右子树
                    // 叶节点，直接删除
                    successorNode.fatherNode.leftChildNode = null;

                    replaceNode(node, successorNode);
                }
            }
        } else {// 没有子节点
            if (node.isLeftChild) {
                node.fatherNode.leftChildNode = null;
            } else if (node.isRightChild) {
                node.fatherNode.rightChildNode = null;
            }
        }
        node = null;
    }

    /**
     * 非相邻节点的替换逻辑(非相邻加粗!)
     *
     * @param node        被替换节点
     * @param replaceNode 替换的节点
     */
    private void replaceNode(Node node, Node replaceNode) {
        if (node.isLeftChild)
            node.fatherNode.leftChildNode = replaceNode;
        else if (node.isRightChild)
            node.fatherNode.rightChildNode = replaceNode;
        else {// node是根节点
            treeRoot = replaceNode;
        }

        node.leftChildNode.fatherNode = node.rightChildNode.fatherNode = replaceNode;
        replaceNode.leftChildNode = node.leftChildNode;
        replaceNode.rightChildNode = node.rightChildNode;
    }

    /**
     * 获取一个节点的后继节点
     *
     * @param node 传参节点
     * @return 返回节点
     */
    private Node getSuccessorNode(Node node) {
        if (!node.haveRightChild()) { // 没有右子树
            return null;
        }

        Node targetNode = node.rightChildNode;
        while (targetNode.haveLeftChild()) { // 找右子树的最左孩子，保证返回的节点一定没有左子树
            targetNode = targetNode.leftChildNode;
        }
        return targetNode;
    }

    /**
     * 删除树中的数据
     * @param baseData  要删除的树
     */
    public void deleteData(T baseData) {
        Node node = searchNode(baseData);
        if (node == null) {
            System.out.println("节点不存在");
            return;
        }
        deleteNode(node);
    }

    /**
     * 遍历节点，从根节点开始
     *
     * @param node 遍历节点
     */
    private void preOrder(Node node) {
        System.out.println("" + node.data.toString());
        if (node.haveLeftChild())
            preOrder(node.leftChildNode);

        if (node.haveRightChild())
            preOrder(node.rightChildNode);
    }

    /**
     * 遍历树(前序遍历)
     */
    public void preOrder() {
        System.out.println("遍历节点（前序遍历）==》");
        if (treeRoot == null)
            return;
        preOrder(treeRoot);
    }
}