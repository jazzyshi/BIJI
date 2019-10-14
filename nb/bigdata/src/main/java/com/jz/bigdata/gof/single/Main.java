package com.jz.bigdata.gof.single;/**
 * Created by jazzyshi on 2019/9/10.
 */

/**
 * @ClassName Main
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/10 15:29
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        SingleHungryModel s1 = SingleHungryModel.getInstance();
        SingleHungryModel s2 = SingleHungryModel.getInstance();

        System.out.println(s1 ==s2 );
    }
}
