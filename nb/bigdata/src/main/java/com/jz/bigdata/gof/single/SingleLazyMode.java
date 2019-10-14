package com.jz.bigdata.gof.single;/**
 * Created by jazzyshi on 2019/9/10.
 */

/**
 * @ClassName SingleLazyMode
 * @Description 懒汉式单例模式
 * @Author jazzyshi
 * @Date 2019/9/10 15:34
 * @Version 1.0
 **/
public class SingleLazyMode {

    private static SingleLazyMode single;

    private SingleLazyMode(){};//私有化构造器

    public static synchronized SingleLazyMode getInstance(){

        if(null == single){
            single = new SingleLazyMode();
        }
        return single;
    }
}
