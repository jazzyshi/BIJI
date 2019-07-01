package com.shijizhuo.gof.structure.bridage;

import com.shijizhuo.gof.structure.bridage.Branch;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by jzshi on 2019/7/1.
 */
public class HuaShuoBranch implements Branch {
    @Override
    public void sale() {
        System.out.println("华硕销售");
    }
}
