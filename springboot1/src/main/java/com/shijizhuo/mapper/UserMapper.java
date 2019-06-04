package com.shijizhuo.mapper;/**
 * Created by jazzyshi on 2019/6/2.
 */

import com.shijizhuo.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/2 14:39
 * @Version 1.0
 **/
@Repository
public interface UserMapper {

    void insertUser(User user);

    User Se(int id);

    List<User> SelList();

    void Del(int id);
}
