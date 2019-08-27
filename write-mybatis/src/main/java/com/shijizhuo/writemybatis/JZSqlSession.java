package com.shijizhuo.writemybatis;


import java.lang.reflect.Proxy;

/**
 * Created by jzshi on 2019/6/23.
 */
public class JZSqlSession {
    private Executor executor = new SimpleExecutor();

    public <T> T selectOne(String statement,String parameter){

       return executor.query(statement,parameter);
    }

    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(this,clazz));
    }


}

