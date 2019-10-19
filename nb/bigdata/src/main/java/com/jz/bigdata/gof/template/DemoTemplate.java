package com.jz.bigdata.gof.template;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName DemoTemplate
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 14:32
 * @Version 1.0
 **/
public abstract class DemoTemplate {
    public void do1(){
        System.out.println("取号");
    }
    public abstract void do2();

    public void do3(){
        System.out.println("评分");
    }

    public final void process(){
        do1();
        do2();
        do3();
    }
}
