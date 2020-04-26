package com.jz.bigdata.other.demoexception;

import java.io.IOException;

public class Demo {

    /**
     * 因为ArithmeticException是运行时异常 所以编译能够通过
     */
    public void doSomeThing(){
        throw new ArithmeticException();
    }
    /**
     * 因为ArithmeticException是运行时异常 所以编译能够通过
     */
    public void doSomeThing1() throws ArithmeticException{

    }

    /**
     * 由于IOException是属于检测异常，编译器强制去捕获此类异常 所以demo.doSomeThing3();编译报错
     * @throws IOException
     */
    public void doSomeThing3() throws IOException{
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.doSomeThing();
        demo.doSomeThing1();
        //demo.doSomeThing3();
    }
}
