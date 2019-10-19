package com.shijizhuo.gof.structure.composite;

/**
 * 抽象组建
 * Created by jzshi on 2019/7/2.
 */
public interface AbstractFile {

    void operate();
}

class TxtLeaf implements AbstractFile {

    String name;

    public TxtLeaf(String name){
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println(name+"进行杀毒");
    }
}

class VideoLeaf implements AbstractFile {
    String name;

    public VideoLeaf(String name){
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println(name+"进行杀毒");
    }
}

