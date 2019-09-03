package com.jz.bigdata.myinternet.mycoucurrent.design014.myself;/**
 * Created by jazzyshi on 2019/8/29.
 */

/**
 * @ClassName MyRealData
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/8/29 15:44
 * @Version 1.0
 **/
public class MyRealData implements Mydata{

    private String result;

    public MyRealData(String queryParam){

        System.out.println("根据请求参数"+queryParam+"进行查询，这是个很耗时的时间");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = "3.141592653" ;
        System.out.println("查询完毕");
    }

    @Override
    public String getRequest() {
        return result;
    }
}
