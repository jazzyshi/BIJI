package com.shijizhuo.demo.service;/**
 * Created by jazzyshi on 2019/6/2.
 */

import com.shijizhuo.demo.RedisConfiguration;
import com.shijizhuo.demo.entity.User;
import com.shijizhuo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    private  StringRedisTemplate st;

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate rs;

    public void insert(User user){
        userMapper.insertUser(user);
    }


    /**
     cacheNames
     指定缓存使用的仓库（我理解为仓库），人以类聚物以群分
     key
     指定缓存的key如果方法没有参数,则使用0作为key
     如果只有一个参数,且未定义key,使用该参数作为key
     如果又多个参数,且未定义key,使用包含所有参数的hashCode作为key
     unless
     如果方法返回null,也会被认为是一种返回值,null也会被缓存,有些时候这不是我们希望的
     通过该属性来控制,禁止缓存null
     #result 可以引用到方法的结果值，通过 == null判断，如果为true，那么就不缓存

     sync
     bool值，默认为 false
     如果该值为true,那么在缓存不存在的时候，仅仅只有一个线程能访问到该方法，其他线程对该方法的访问全部被阻塞,直到缓存可用
     设置为true,可以防止在并发较大的时候，缓存击穿而导致多个请求直接打到DB。
     */
    @Cacheable(cacheNames = "demo",unless="#result == null")
    public User Se(int id){

         st.opsForValue().set(id+"","id"+id);

        System.out.println("redis"+st.opsForValue().get("id")+3);

        return userMapper.Se(id);
    }

    public List<User> SelList(){
        return userMapper.SelList();
    }

    public void Del(int id) {
         userMapper.Del(id);
    }
}
