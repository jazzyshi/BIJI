package com.jz.bigdata.gof.myobserver;/**
 * Created by jazzyshi on 2019/9/17.
 */

import java.util.Observable;

/**
 * @ClassName MySubject
 * @Description 目标对象
 * @Author jazzyshi
 * @Date 2019/9/17 14:56
 * @Version 1.0
 **/
public class MySubject extends Observable{

    private int state;

    public void set(int s){
        state = s; //目标对象的状态发生了变化
        setChanged();//表示目标对象已经做了更改
        notifyObservers(state);//通知所有的观察者
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
