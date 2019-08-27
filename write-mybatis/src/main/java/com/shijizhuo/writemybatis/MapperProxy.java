package com.shijizhuo.writemybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jzshi on 2019/6/23.
 */
public class MapperProxy<T> implements InvocationHandler {

    private final JZSqlSession sqlSession ;
    private final Class<T> mapperInterface ;

    public MapperProxy(JZSqlSession jzSqlSession, Class<T> mapperInterface) {
        this.sqlSession = jzSqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(UserMappingXml.nameSpace)){
            String sql =  UserMappingXml.methodSqlMapping.get(method.getName());
            System.out.println(sql);

            return sqlSession.selectOne(sql,"1");
        }
        return null;
    }
}
