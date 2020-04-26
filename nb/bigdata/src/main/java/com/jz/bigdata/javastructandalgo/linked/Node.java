package com.jz.bigdata.javastructandalgo.linked;

/**
 * 链表的一个节点
 */
public class Node {

    int data;
    Node next = null;
    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
