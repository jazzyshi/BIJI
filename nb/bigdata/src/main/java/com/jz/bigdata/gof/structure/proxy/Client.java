package com.jz.bigdata.gof.structure.proxy;/**
 * Created by jazzyshi on 2019/9/12.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/12 11:47
 * @Version 1.0
 **/
public class Client {

    public static void main(String[] args) {
        RealStart s1 = new RealStart();
        Start s2 = new ProxyStar(s1);

        s2.bookTinckrt();
        s2.singing();
    }
}
