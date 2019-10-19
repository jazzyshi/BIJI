package com.shijizhuo.gof.structure.facade;

/**
 * 工商局
 * Created by jzshi on 2019/7/2.
 */
public interface GSJU {
  void sign();
}

class NJGSJU implements GSJU{

    @Override
    public void sign() {
        System.out.println("已注册登记");
    }
}