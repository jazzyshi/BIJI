package com.shijizhuo.gof.structure.facade;

/**
 * Created by jzshi on 2019/7/2.
 */
public interface Bank {
    void openAccount();
}

class GongShangBank implements Bank{

    @Override
    public void openAccount() {
        System.out.println("开户成功");
    }
}