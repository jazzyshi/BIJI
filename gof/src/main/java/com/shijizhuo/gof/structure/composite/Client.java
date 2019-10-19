package com.shijizhuo.gof.structure.composite;

/**
 * Created by jzshi on 2019/7/2.
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile c1 = new TxtLeaf("1.txt");
        AbstractFile c2 = new TxtLeaf("2.txt");
        AbstractFile c3 = new VideoLeaf("笑傲江湖.avi");
        AbstractFile c4 = new VideoLeaf("神雕侠侣.avi");
        c1.operate();
        c2.operate();
        c3.operate();
        c4.operate();

        Folder wenjianjia = new Folder();
        wenjianjia.add(c1);
        wenjianjia.add(c2);
        wenjianjia.add(c3);
        wenjianjia.add(c4);
        wenjianjia.operate();

    }
}
