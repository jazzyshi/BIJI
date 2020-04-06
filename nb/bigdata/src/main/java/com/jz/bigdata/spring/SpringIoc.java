package com.jz.bigdata.spring;

/**
 * spring中的Ioc的实现原理就是工厂模式加反射机制
 */
interface Fruit{
    public abstract void eat();
}
class Apple implements Fruit{

    @Override
    public void eat() {
        System.out.println("apple");
    }
}
class Orange implements Fruit{

    @Override
    public void eat() {
        System.out.println("Orange");
    }
}
public class SpringIoc {
    public static Fruit getInstance(String className){
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  fruit;
    }
}

class Client{
    public static void main(String[] args) {
        Fruit f = SpringIoc.getInstance("com.jz.bigdata.spring.Apple");
        f.eat();
    }
}
