package com.jz.bigdata.gof.prototype;/**
 * Created by jazzyshi on 2019/9/12.
 */

import java.io.*;
import java.util.Date;

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/9/12 9:59
 * @Version 1.0
 **/
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ShallowCopy s1 = new ShallowCopy();
        s1.setName("shijizhuo");
        s1.setAge(18);
        s1.setDate(new Date());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream oit = new ObjectInputStream(bis);

        ShallowCopy s2 = (ShallowCopy) oit.readObject();

        s2.setName("new-shijizhbuo");


        System.out.println(s1.getName());
        System.out.println(s2.getName());

    }
}
