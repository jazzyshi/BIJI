package com.jz.bigdata.java8.functioninterface.demo1;

/**
 * 函数式接口的使用：一般可以作为方法的参数或返回值的类型
 */
public class MainTest {

    /**
     * 定义一个方法。参数使用函数式接口：MyFunctionInterface
     * @param myFunctionInterface
     */
    public static void show(MyFunctionInterface myFunctionInterface){
        myFunctionInterface.method();
    }

    public static void main(String[] args){

        //调用show方法，方法的参数是一个接口，所以可以传递接口的实现类方法
        show(new MyFunctionInterfaceImp());
        //调用show方法，方法的参数是一个接口，所以可以传递接口的匿名内部类
        show(new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        });
        //调用show方法，方法的参数是一个函数式接口，所以可以lambda表达式
        show(() -> System.out.println("lambda表达式"));
    }
}
