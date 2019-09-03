package com.jz.bigdata.myinternet.mycoucurrent.design014.myself;/**
 * Created by jazzyshi on 2019/8/29.
 */

/**
 * @ClassName MyFutureClient
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/8/29 16:12
 * @Version 1.0
 **/
public class MyFutureClient {

    public Mydata getMyData(final String queryParam){

        //1.先返回实现一个data接口类的代理给客户端，告诉客户端我收到你的请求了，你可以作其它的事情了
        final MyFuterData myFuterData =  new MyFuterData();
        //2.再新启一个线程获取真正的数据,然后传给代理
        new Thread(new Runnable() {
            @Override
            public void run() {
                //可以慢慢加载真实的数据给代理
                MyRealData myRealData = new MyRealData(queryParam);
                myFuterData.setRealData(myRealData);
            }
        }).start();

        return myFuterData;

    }

}
