package com.jz.bigdata.gof.single;/**
 * Created by jazzyshi on 2019/9/10.
 */

/**
 * @ClassName SingleStaticInner
 * @Description 静态内部类实现单利模式
 * @Author jazzyshi
 * @Date 2019/9/10 16:10
 * @Version 1.0
 **/
public class SingleStaticInner {


    private static class TempClass {
        private static final SingleStaticInner sc = new SingleStaticInner();
    }

    private SingleStaticInner(){//私有化构造器

    }

    private static SingleStaticInner getInstance(){

        return TempClass.sc;
    }

    public static void main(String[] args) {
        System.out.println(SingleStaticInner.getInstance());
        System.out.println(SingleStaticInner.getInstance());
        System.out.println(SingleStaticInner.getInstance()); System.out.println(SingleStaticInner.getInstance());

    }
}
