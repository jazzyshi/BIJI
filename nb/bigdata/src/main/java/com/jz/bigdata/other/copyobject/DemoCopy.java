package com.jz.bigdata.other.copyobject;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 对象的复制
 */
public class DemoCopy {

    private String a;
    private int b;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        DemoCopy copy = new DemoCopy();
        copy.setA("a");
        copy.setB(1);
        DemoCopy copy1 = new DemoCopy();
        BeanUtils.copyProperties(copy1,copy);
        DemoCopy copy2 = new DemoCopy();
        copy2 = (DemoCopy) BeanUtils.cloneBean(copy);
        System.out.println(copy1.getA());
        System.out.println(copy2.getA());

        try {
            throw new Throwable();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
