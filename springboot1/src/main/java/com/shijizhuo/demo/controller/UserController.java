package com.shijizhuo.demo.controller;/**
 * Created by jazzyshi on 2019/6/2.
 */

import com.shijizhuo.demo.entity.User;
import com.shijizhuo.demo.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/2 14:36
 * @Version 1.0
 **/
//@Controller  //返回模板
@RestController //返回json
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServer userServer;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        this.userServer.insert(user);
        return "ok";
    }

    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id){
        return userServer.Se(id);
    }
    @RequestMapping("getUserList")
    public List<User> GetUser(){
        return userServer.SelList();
    }
    @RequestMapping("/del/{id}")
    public void Del(@PathVariable int id){
         userServer.Del(id);
    }
}
