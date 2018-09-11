package cn.lxj.test;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * LinkedStack
 * description 链式栈，就是采用链式存储结构的栈，由于我们操作的是栈顶一端，因此这里采用单链表（不带头结点）作为基础，直接实现栈的添加，获取，删除等主要操作即可
 * create by lxj 2018/9/4
 **/
public class LinkedStack<T> extends Stack<T> implements Serializable {
    private static final long serialVersionUID = 1911829302658328353L;
    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = new Node<>();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return top == null || top.data == null;
    }

    @Override
    public T push(T data){
        if (data == null) {
            throw new RuntimeException("data can\'t be null");
        }
        if (this.top == null) {
            // 调用pop（）后，top可能为null
            this.top = new Node<>(data);
        } else if (this.top.data == null) {
            this.top.data = data;
        } else {
            Node p = new Node<>(data,this.top);
            top = p;//更新栈
        }
        size ++;
        return data;
    }

    @Override
    public T peek()  {
        if(isEmpty()){
            throw new RuntimeException("Stack empty");
        }
        return top.data;
    }
    @Override
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack empty");
        }
        T data=top.data;
        top=top.next;
        size--;
        return data;
    }

    //测试
    public static void main(String[] args){
        LinkedStack<String> sl=new LinkedStack<>();
        sl.push("A");
        sl.push("B");
        sl.push("C");
        int length=sl.size();
        for (int i = 0; i < length; i++) {
            System.out.println("sl.pop->"+sl.pop());
        }
    }
}
