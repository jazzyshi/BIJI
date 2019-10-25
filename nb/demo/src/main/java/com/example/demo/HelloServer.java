package com.example.demo;/**
 * Created by jazzyshi on 2019/9/20.
 */

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HelloServer
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/20 11:34
 * @Version 1.0
 **/
@Service
public class HelloServer {

    @Cacheable(value = "users")
    public Map<String,Object> findUserById(Integer id){

        System.out.println("我爱你");
        Map<String,Object>  maps = new HashMap<>();
        maps.put("aa","ccccc");

        return maps;

    }
}
