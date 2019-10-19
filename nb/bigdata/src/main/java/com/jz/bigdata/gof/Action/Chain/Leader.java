package com.jz.bigdata.gof.Action.Chain;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Leader
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 10:17
 * @Version 1.0
 **/
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;//责任链上的后继对象

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public Leader(String name){
        super();
        this.name = name;
    }

    public abstract void handleRequest(LeavRequest leavRequest);
}
