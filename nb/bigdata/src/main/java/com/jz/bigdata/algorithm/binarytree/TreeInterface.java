package com.jz.bigdata.algorithm.binarytree;

public interface TreeInterface {

    boolean isEmpty();
    int size();
    int height();
    Node find(Object obj);
    void preSort();
    void middleSort();
    void middleSortByStack();
    void postSort();

    void levelSort();
    void insert(Object obj);

}
