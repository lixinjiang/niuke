package cn.lxj.treenote;

import java.util.Random;

/**
 * Test
 * description 测试
 * create class by lxj 2018/9/10
 **/
public class Test {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testArray1 = {56, 23, 54, 98, 67, 53, 12, 76, 45, 99, 32, 47, 6};
        int target = 9;
        // 根节点
        BinaryTree<TestBean> binaryTree = new BinaryTree<>();
        for (int i = 0; i < 10; i++) {
            TestBean tb = new TestBean();
            tb.number = testArray1[i];
            tb.message = "" + tb.number;
            System.out.println("insert: " + tb.number);
            binaryTree.insertNode(tb);
        }

        binaryTree.preOrder();
        binaryTree.deleteData(new TestBean(12));
        System.out.println("-----------Test-----------");
        binaryTree.preOrder();

        TestBean targetData = new TestBean();
        targetData.number = 23;
        TestBean result = (TestBean) binaryTree.searchData(targetData);
        System.out.println("result = " + (result == null ? "null" : result.message));
    }
}