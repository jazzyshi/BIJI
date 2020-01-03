package com.jz.springcloud.api;/**
 * Created by jazzyshi on 2019/11/20.
 */

import com.jz.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @ClassName UserAPI
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/20 15:46
 * @Version 1.0
 **/
@FeignClient("user-api")
public interface UserAPI {

    @GetMapping("/user-api")
    Collection<User> users();
}
