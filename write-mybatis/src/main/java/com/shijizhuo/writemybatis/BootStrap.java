package com.shijizhuo.writemybatis;

/**
 * Created by jzshi on 2019/6/23.
 */
public class BootStrap {

    public static void start(){
        JZSqlSession sqlSession = new JZSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectByPrimaryKey(1);

        System.out.println(user);
    }

    public static void main(String[] args) {
        start();
    }


}
