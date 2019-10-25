package com.example.demo;/**
 * Created by jazzyshi on 2019/9/19.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName HelloController
 * @Description
 * @Author jazzyshi
 * @Date 2019/9/19 14:45
 * @Version 1.0
 **/

@RestController
public class HelloController {

    @Autowired
    HelloServer helloServer;

    @RequestMapping("/hello")
    public Map<String,Object> helloWord(@Param("id") int id){
       return helloServer.findUserById(id);
    }

}
