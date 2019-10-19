package com.jz.bigdata.gof.Action.Chain;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName GuoLiangLeader
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 10:21
 * @Version 1.0
 **/
public class AllenLeader extends Leader {
    public AllenLeader(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeavRequest leavRequest) {
        if(leavRequest.getDay() > 3){
            System.out.println("员工"+leavRequest.getName()+"请假"+leavRequest.getDay());
            System.out.println("Allen审核通过");
        }
    }
}
