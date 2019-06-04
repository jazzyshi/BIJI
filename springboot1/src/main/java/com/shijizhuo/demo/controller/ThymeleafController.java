package com.shijizhuo.demo.controller;/**
 * Created by jazzyshi on 2019/6/4.
 */

import com.shijizhuo.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Thymeleaf
 * @Description TODO
 * @Author jazzyhi
 * @Date 2019/6/4 21:01
 * @Version 1.0
 **/
@Controller
@RequestMapping("/u")
public class ThymeleafController {

    @RequestMapping("/show3")
    public String show3(ModelMap model){
        List<User> list = new ArrayList<>();

        model.addAttribute("userList",list);
        model.addAttribute("msg","男");
        return "index3";
    }
}
