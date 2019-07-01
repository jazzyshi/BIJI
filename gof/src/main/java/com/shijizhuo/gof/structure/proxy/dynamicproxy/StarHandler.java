package com.shijizhuo.gof.structure.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jzshi on 2019/6/30.
 */
public class StarHandler implements InvocationHandler {

    Star realstar;
    public StarHandler(Star star){
        super();
        this.realstar = star;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("@@@@");
        //1.切面方法1
        //2.切面方法2

        Object object = null;
        if(method.getName().equals("sing")){
            object = method.invoke(realstar,args);
        }

        return object;
    }
}
