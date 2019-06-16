package com.dubbo1.demo.provider;

import com.dubbo1.demo.DemoService;

/**
 * Created by jzshi on 2019/6/10.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "你好"+name;
    }

    @Override
    public float getPrice(String name) {
        return 12.10f;
    }
}
