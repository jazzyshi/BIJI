package com.jz.bigdata.myinternet.mycoucurrent.design014.myself;/**
 * Created by jazzyshi on 2019/8/29.
 */

/**
 * @ClassName MyFuterData
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/8/29 15:46
 * @Version 1.0
 **/
public class MyFuterData implements Mydata {

    private MyRealData realData;

    boolean isReady = false;

    public synchronized void setRealData(MyRealData realData) {

        //如果没有装载好
        while (!isReady){
            this.realData = realData;
            isReady = true;
            this.notify();
        }
    }

    @Override
    public synchronized String getRequest() {

        //如果没有装载好，就一直处于阻塞状态
        while(!isReady){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //装载好直接获取数据即可
        return this.realData.getRequest();
    }
}
