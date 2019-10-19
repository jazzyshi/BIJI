package com.jz.bigdata.gof.structure.bridage;/**
 * Created by jazzyshi on 2019/9/16.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/16 15:23
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Computer c1 = new NoteBook(new Dell());
        Computer c2 = new NoteBook(new Lenvo());
        c1.sale();
        c2.sale();
    }
}

