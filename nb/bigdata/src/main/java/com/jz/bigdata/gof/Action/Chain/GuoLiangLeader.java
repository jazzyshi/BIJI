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
public class GuoLiangLeader extends Leader {
    public GuoLiangLeader(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeavRequest leavRequest) {
        if(leavRequest.getDay() <= 3){
            System.out.println("员工"+leavRequest.getName()+"请假"+leavRequest.getDay());
            System.out.println(this.name+"审核通过");
        }else{
            if(this.nextLeader != null){
                nextLeader.handleRequest(leavRequest);
            }
        }
    }
}
