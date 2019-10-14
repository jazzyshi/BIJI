package com.jz.bigdata.gof.single;/**
 * Created by jazzyshi on 2019/9/10.
 */

/**
 * @ClassName SingleHungryModel
 * @Description 饿汉模式 单利模式
 * @Author jazzyshi
 * @Date 2019/9/10 15:24
 * @Version 1.0
 **/
public class SingleHungryModel {

    private static final SingleHungryModel single = new SingleHungryModel();

    private SingleHungryModel(){};//私有化构造器

    public static SingleHungryModel getInstance(){
        return single;
    }
}
