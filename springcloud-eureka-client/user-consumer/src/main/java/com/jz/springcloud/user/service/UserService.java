package com.jz.springcloud.user.service;/**
 * Created by jazzyshi on 2019/11/20.
 */

import com.jz.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/20 11:11
 * @Version 1.0
 **/
@Service
public class UserService {

    private final String PREFIX =  "http://localhost:7777";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public Collection<User> getUsers(){
        ServiceInstance si = this.loadBalancerClient.choose("users");

        String host = si.getHost();
        int port = si.getPort();
        //String Url = PREFIX+"/users";
        String Url = "http://"+host+":"+port+"/users";
        System.err.println(Url);
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(Url,Collection.class);
    }

}
