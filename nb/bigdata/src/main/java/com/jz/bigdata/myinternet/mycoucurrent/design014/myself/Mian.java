package com.jz.bigdata.myinternet.mycoucurrent.design014.myself;/**
 * Created by jazzyshi on 2019/8/29.
 */

/**
 * @ClassName Mian
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/8/29 16:26
 * @Version 1.0
 **/
public class Mian {

    public static void main(String[] args) {
        MyFutureClient myFutureClient = new MyFutureClient();
        Mydata data = myFutureClient.getMyData("请求参数PI");
        System.out.println("发送请求参数成功，我可以作其它的事情了");
        String result = data.getRequest();
        System.out.println("result="+result);
    }
}
