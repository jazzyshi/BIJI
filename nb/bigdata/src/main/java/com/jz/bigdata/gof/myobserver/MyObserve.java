package com.jz.bigdata.gof.myobserver;/**
 * Created by jazzyshi on 2019/9/17.
 */

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName MyObserve
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 14:54
 * @Version 1.0
 **/
public class MyObserve implements Observer {

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((MySubject) o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
