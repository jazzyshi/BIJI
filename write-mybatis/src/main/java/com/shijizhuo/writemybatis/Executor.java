package com.shijizhuo.writemybatis;

/**
 * Created by jzshi on 2019/6/23.
 */
public interface Executor {
    <E> E query(String statement, String paramter);
}
