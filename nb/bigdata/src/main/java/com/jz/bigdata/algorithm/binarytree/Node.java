package com.jz.bigdata.algorithm.binarytree;

import java.util.Objects;

public class Node {
    Object value;
    Node leftNode;
    Node rightNode;

    public Node(Object obj, Node leftNode, Node rightNode) {
        this.value = obj;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
