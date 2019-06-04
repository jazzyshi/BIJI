package com.shijizhuo.demo.service;/**
 * Created by jazzyshi on 2019/6/2.
 */

import com.shijizhuo.demo.entity.User;
import com.shijizhuo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServer
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/2 14:37
 * @Version 1.0
 **/
@Service
public class UserServer {

    @Autowired
    UserMapper userMapper;

    public void insert(User user){
        userMapper.insertUser(user);
    }


    public User Se(int id){
        return userMapper.Se(id);
    }

    public List<User> SelList(){
        return userMapper.SelList();
    }

    public void Del(int id) {
         userMapper.Del(id);
    }
}
