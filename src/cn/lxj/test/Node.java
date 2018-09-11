package cn.lxj.test;

/**
 * Node
 * description TODO
 * create by lxj 2018/9/4
 **/
public class Node<T> {
    T data;
    Node next = null;

    public Node(){}

    public Node (T data) {
        this.data = data;
    }

    public Node(T data,Node next){
        this.data = data;
        this.next = next;
    }
}
