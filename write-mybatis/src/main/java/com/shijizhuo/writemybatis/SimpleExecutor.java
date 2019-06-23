package com.shijizhuo.writemybatis;


/**
 * Created by jzshi on 2019/6/23.
 */
public class SimpleExecutor implements Executor {


    @Override
    public <E> E query(String statement,String paramter){

        User test = new User();

        //数据库连接执行sql 省略

        test.setId(1);
        test.setName("schizo");

        return (E) test;
    }
}
