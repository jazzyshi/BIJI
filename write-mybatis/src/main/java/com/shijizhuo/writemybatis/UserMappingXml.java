package com.shijizhuo.writemybatis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jzshi on 2019/6/23.
 */
public class UserMappingXml{
    public static final String nameSpace = "com.shijizhuo.writemybatis.UserMapper";

    public static final Map<String,String> methodSqlMapping  = new HashMap<>();

    static {
        methodSqlMapping.put("selectByPrimaryKey","select * from user where id = %d");
    }

}
