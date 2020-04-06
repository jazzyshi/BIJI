package com.jz.bigdata.algorithm.binarytree;

import java.util.*;

public class BinaryTree implements TreeInterface {

    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if(root == null){
            return 0;
        }else{
            //左子树的个数
            int sL = size(root.leftNode);
            //右子树的个数
            int sR = size(root.rightNode);
            //左+右+根
            return sL + sR + 1;
        }
    }

    @Override
    public int height() {
        return this.height(root);
    }

    private int height(Node root) {
        if(root == null){
            return 0;
        }else{
            int hL = height(root.leftNode);
            int hR = height(root.rightNode);
            return hL > hR ? hL +1 : hR + 1;
        }
    }

    @Override
    public Node find(Object obj) {
        return this.find(obj,root);
    }

    private Node find(Object obj, Node root) {
        if(root == null){
            return null;
        }
        if(obj == root.value){
            return root;
        }else{
            Node nodeLeft = find(obj,root.leftNode);
            Node nodeRight = find(obj,root.rightNode);
            if(nodeLeft != null){
                return nodeLeft;
            }
            if(nodeRight != null){
                return nodeRight;
            }
            return null;
        }
    }

    @Override
    public void preSort() {
        this.preSort(root);
    }

    private void preSort(Node root) {
        if(root == null) return;
        //打印跟节点
        System.out.println(root);
        //打印左节点
        this.preSort(root.leftNode);
        //打印右节点
        this.preSort(root.rightNode);
    }

    @Override
    public void middleSort() {
        this.middleSort(root);
    }

    /**
     * 中序非递归遍历（借助栈）
     * 1.若根节点不为空，则将其放入栈中，并判断其左子树是否为空
     * 2.若不为空，则将子树跟节点放入栈中，并继续向下判断,直到左子树为空
     * 3.若栈中有节点，则将其取出，并对其右子树跟节点进行1，2步操作，直到无节点或栈中元素为空
     */
    @Override
    public void middleSortByStack() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.leftNode;
            }

            if(!stack.isEmpty()){
                current = stack.pop();
                System.out.println(current);
                current = current.rightNode;
            }
        }
    }

    private void middleSort(Node root) {
        if(root == null){
            return;
        }else{
            //打印左节点
            middleSort(root.leftNode);
            //打印跟节点
            System.out.println(root);
            //打印右节点
            middleSort(root.rightNode);
        }
    }

    @Override
    public void postSort() {
        this.postSort(root);
    }

    /**
     * 按照层次遍历（借助队列）:
     * 按照从上往下、从左往右的次序进行遍历。先遍历完一层，再遍历下一层
     * 又叫做广度优先遍历
     */
    @Override
    public void levelSort() {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size() != 0){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Node temp = queue.poll();
                System.out.println(temp);
                if(temp.leftNode != null){
                    queue.add(temp.leftNode);
                }
                if(temp.rightNode != null){
                    queue.add(temp.rightNode);
                }
            }

        }
    }

    @Override
    public void insert(Object obj) {

    }

    private void postSort(Node root) {
        if(root == null){
            return;
        }else{
            //打印左节点
            postSort(root.leftNode);
            //打印右节点
            postSort(root.rightNode);
            //答应跟节点
            System.out.println(root);
        }
    }

}
