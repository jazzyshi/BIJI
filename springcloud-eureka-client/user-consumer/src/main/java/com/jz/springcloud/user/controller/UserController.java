package com.jz.springcloud.user.controller;/**
 * Created by jazzyshi on 2019/11/20.
 */

import com.jz.springcloud.model.User;
import com.jz.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/20 11:24
 * @Version 1.0
 **/
@RestController
@LoadBalancerClient("aa")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/c-users")
    public Collection<User> getUsers(){
        return this.userService.getUsers();
    }
}
