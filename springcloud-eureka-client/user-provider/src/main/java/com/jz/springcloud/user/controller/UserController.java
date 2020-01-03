package com.jz.springcloud.user.controller;/**
 * Created by jazzyshi on 2019/11/20.
 */

import com.jz.springcloud.api.UserAPI;
import com.jz.springcloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/20 10:42
 * @Version 1.0
 **/
@RestController
@Component
public class UserController implements UserAPI{

    @GetMapping("/users")
    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<User> getUsers(){
        Collection<User> users = new ConcurrentLinkedDeque<>();
        users.add(new User(1,"史继卓1",18));
        users.add(new User(2,"史继卓2",19));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  users;
    }

    public Collection<User> fallback(){
        return Collections.EMPTY_LIST;
    }

    @Override
    public Collection<User> users() {
        Collection<User> users = new ConcurrentLinkedDeque<>();
        users.add(new User(1,"史继卓1",18));
        users.add(new User(2,"史继卓2",19));
        return  users;
    }
}
