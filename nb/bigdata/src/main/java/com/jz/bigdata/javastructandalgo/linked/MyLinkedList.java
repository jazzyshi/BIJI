package com.jz.bigdata.javastructandalgo.linked;

import java.util.Hashtable;

/**
 * 链表的基本操作
 */
public class MyLinkedList {

    Node head = null; //链表头的引用


    public static void main(String[] args){

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addNode(1);
        myLinkedList.addNode(5);
        myLinkedList.addNode(3);
        myLinkedList.addNode(1);

        myLinkedList.orderNode();
        myLinkedList.printNode();
       // myLinkedList.deleetNode(3);
        System.out.println("----------");
        //myLinkedList.deleteDup1();
        //myLinkedList.printNode();
        System.out.println(myLinkedList.findNodeX(2).data);

    }

    /**
     * 获取倒数第K个元素
     * @param k 倒数第K个元素
     * @return 返回
     */
    public Node findNodeX(int k){

        if(head == null || k < 1){
            return null;
        }
        Node p = head;
        for(int i=1;i<=k-1 && p != null;i++){
            p = p.next;
        }

        if(p == null){
            System.out.println("k的取值范围不合法");
            return null;
        }

        Node q = head;
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        return  q;
    };

    /**
     * 删除重复节点---时间复杂度低，空间复杂度高
     */
    public void deleteDup(){
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        Node temp = head;
        Node curr = null;
        while(temp!= null){
            if(hashTable.containsKey(temp.data)){
                curr.next = temp.next;
            }else {
                hashTable.put(temp.data,1);
                curr = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除重复节点---时间复杂度高，空间复杂度低
     * 双重循环遍历
     */
    public void deleteDup1(){
        Node p = head;
        while (p != null){
            Node q = p;
            while (q.next != null){
                if(p.data == q.next.data){
                    q.next = q.next.next;
                }else{
                    q = q.next;
                }
            }
            p = p.next;
        }
    }



    /**
     * 向链表中插入数据
     * @param data 待插入的数据
     */
    public void addNode(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 获取链表的长度
     * @return 链表的长度
     */
    public int length(){
        int length = 0;
        Node temp = head;
        while(temp.next != null){
            length ++;
        }
        return length;
    }

    /**
     * 删除指定位置上的节点
     * @param index 删除第index个节点
     * @return 成过返回true,失败返回false
     */
    public Boolean deleetNode(int index){

        if(index < 1 && index > length()){
            return false;
        }

        //删除链表第一个元素
        if(index == 1){
            head = head.next;
            return true;
        }

        int t = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode.next != null){
            if(index == t){
               preNode.next = curNode.next; //丢弃掉要删除的元素
               return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            t ++ ;
        }
        return true;
    }

    /**
     * 对链表进行排序
     * @return 返回排序后头节点
     */
    public Node orderNode(){
        int temp = 0;
        Node currentNode = head;
        Node nextNode = null;
        while(currentNode != null){
            nextNode = currentNode.next;
            while (nextNode != null){
                if(currentNode.data > nextNode.data){
                    temp = nextNode.data;
                    nextNode.data = currentNode.data;
                    currentNode.data =  temp;
                }
                nextNode = nextNode.next;
            }
            currentNode = currentNode.next;
        }
        return  head;
    }

    /**
     * 打印链表
     */
    public void printNode(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }



}
