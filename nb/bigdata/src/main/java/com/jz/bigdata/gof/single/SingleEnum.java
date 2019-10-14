package com.jz.bigdata.gof.single;

/**
 * Created by jazzyshi on 2019/9/11.
 */
public enum SingleEnum {

    INSTANCE;


    public static void main(String[] args) {
        System.out.println(SingleEnum.INSTANCE == SingleEnum.INSTANCE);
    }
}
