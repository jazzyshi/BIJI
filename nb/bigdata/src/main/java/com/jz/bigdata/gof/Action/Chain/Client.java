package com.jz.bigdata.gof.Action.Chain;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 10:43
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        LeavRequest leavRequest = new LeavRequest("shijizhuo","调休年假",5);

        Leader a = new GuoLiangLeader("郭亮");
        Leader b = new AllenLeader("allen");

        a.setNextLeader(b);

        a.handleRequest(leavRequest);
    }
}
