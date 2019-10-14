package com.jz.bigdata.gof.myobserver;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 15:03
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {

        //创建目标对象observable
        MySubject mySubject = new MySubject();

        //创建观察者
        MyObserve obs1 = new MyObserve();
        MyObserve obs2 = new MyObserve();
        MyObserve obs3 = new MyObserve();

        //将上面的观察者对象添加到目标对象的观察者列表当中
        mySubject.addObserver(obs1);
        mySubject.addObserver(obs2);
        mySubject.addObserver(obs3);

        //改变subject对象的状态
        mySubject.set(10);
        System.out.println("=====状态修改了====");
        //观察者的状态发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());


        //改变subject对象的状态
        mySubject.set(680);
        System.out.println("=====状态修改了====");
        //观察者的状态发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

    }
}
