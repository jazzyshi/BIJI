package com.shijizhuo.gof.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 相当于文件夹
 * Created by jzshi on 2019/7/2.
 */
public class Folder implements AbstractFile {

    List<AbstractFile> cList = new ArrayList<>();


    @Override
    public void operate() {
        for(AbstractFile component : cList){
            component.operate();
        }
    }

    public void add(AbstractFile c){
        cList.add(c);
    }

    public void remove(AbstractFile c){
        cList.remove(c);
    }

}
