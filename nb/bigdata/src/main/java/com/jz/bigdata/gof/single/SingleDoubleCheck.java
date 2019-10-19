package com.jz.bigdata.gof.single;/**
 * Created by jazzyshi on 2019/9/10.
 */

/**
 * @ClassName SingleDoubleCheck
 * @Description 双重检测
 * @Author jazzyshi
 * @Date 2019/9/10 15:46
 * @Version 1.0
 **/
public class SingleDoubleCheck {

    private static SingleDoubleCheck instance = null;
    public static SingleDoubleCheck getinstance(){

        if(instance == null){
            synchronized (SingleDoubleCheck.class){
                if(instance == null){
                    synchronized (SingleDoubleCheck.class){
                        instance = new SingleDoubleCheck();
                    }
                }
            }

            return instance;
        }
        return instance;
    }

    private SingleDoubleCheck(){

    }


    public static void main(String[] args) {
        System.out.println(SingleDoubleCheck.getinstance());
        System.out.println(SingleDoubleCheck.getinstance());
    }

}
