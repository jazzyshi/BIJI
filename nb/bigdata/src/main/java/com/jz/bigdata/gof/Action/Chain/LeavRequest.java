package com.jz.bigdata.gof.Action.Chain;/**
 * Created by jazzyshi on 2019/9/17.
 */

/**
 * @ClassName LeavRequest
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/17 10:13
 * @Version 1.0
 **/
public class LeavRequest {
    private String name;
    private String reason;
    private int day;


    public LeavRequest(String n,String r,int d){
        this.name = n;
        this.reason = r;
        this.day = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
