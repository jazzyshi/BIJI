package com.shijizhuo.gof.structure.facade;

/**
 * Created by jzshi on 2019/7/2.
 */
public class CommonFacade {

    Bank b = new GongShangBank();
    GSJU g = new NJGSJU();

    public void openCommany(){
        b.openAccount();
        g.sign();
    }

}
