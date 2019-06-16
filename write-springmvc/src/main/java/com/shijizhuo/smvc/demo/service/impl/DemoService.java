package com.shijizhuo.smvc.demo.service.impl;

import com.shijizhuo.smvc.annotation.JZService;
import com.shijizhuo.smvc.demo.service.IDemoService;

/**
 * Created by jzshi on 2019/6/16.
 */
@JZService
public class DemoService implements IDemoService {
    @Override
    public String get(String name) {
        return "我爱你"+name;
    }
}
