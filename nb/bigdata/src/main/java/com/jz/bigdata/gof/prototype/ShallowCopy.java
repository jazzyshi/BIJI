package com.jz.bigdata.gof.prototype;/**
 * Created by jazzyshi on 2019/9/12.
 */

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ShallowCopy
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/12 9:56
 * @Version 1.0
 **/
public class ShallowCopy implements Cloneable,Serializable{

    private String name ;
    private int age;
    private Date date;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
