package com.shijizhuo.gof.create.singlelon;

import java.io.*;

/**
 * Created by jzshi on 2019/6/24.
 */
public class Client {

    public static void main(String[] args) {
        BreakSingleton s1 = BreakSingleton.getInstance();
        BreakSingleton s2 = BreakSingleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        //通过反射的方式直接调用私有构造器
//        try {
//            Class<BreakSingleton> clazz = (Class<BreakSingleton>) Class.forName("com.shijizhuo.gof.create.singlelon.BreakSingleton");
//            Constructor<BreakSingleton> c = clazz.getDeclaredConstructor(null);
//
//            c.setAccessible(true);
//            BreakSingleton s3 = c.newInstance();
//            BreakSingleton s4 = c.newInstance();
//
//            System.out.println(s3);
//            System.out.println(s4);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        //通过反序列化的方式构造多个对象
        BreakSingleton s3 = BreakSingleton.getInstance();
        System.out.println(s3);
        try {
            FileOutputStream fos = new FileOutputStream("c:/jzshi/1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s3);
            oos.close();
            fos.close();

            ObjectInput ois = new ObjectInputStream(new FileInputStream("c:/jzshi/1.txt"));
            BreakSingleton s4 = (BreakSingleton) ois.readObject();
            System.out.println(s4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
