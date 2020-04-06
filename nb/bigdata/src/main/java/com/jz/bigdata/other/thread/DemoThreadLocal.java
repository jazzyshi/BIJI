package com.jz.bigdata.other.thread;

/**
 * ThreadLocal是什么呢？其实ThreadLocal并非是一个线程的本地实现版本，它并不是一个Thread，
 * 而是threadlocalvariable(线程局部变量)。
 * 也许把它命名为ThreadLocalVar更加合适。
 * 线程局部变量(ThreadLocal)其实的功用非常简单，
 * 就是为每一个使用该变量的线程都提供一个变量值的副本，
 * 是Java中一种较为特殊的线程绑定机制，是每一个线程都可以独立地改变自己的副本，而不会和其它线程的副本冲突。
 *
 * WeakReference是Java语言规范中为了区别直接的对象引用（程序中通过构造函数声明出来的对象引用）而定义的另外一种引用关系。
 * WeakReference标志性的特点是：reference实例不会影响到被应用对象的GC回收行为（
 * 即只要对象被除WeakReference对象之外所有的对象解除引用后，该对象便可以被GC回收），
 * 只不过在被对象回收之后，reference实例想获得被应用的对象时程序会返回null。
 *

 * 理解了WeakReference之后，ThreadLocalMap使用它的目的也相对清晰了：
 * 当threadLocal实例可以被GC回收时，系统可以检测到该threadLocal对应的Entry是否已经过期
 * （根据reference.get() == null来判断，如果为true则表示过期，程序内部称为stale slots）来自动做一些清除工作，
 * 否则如果不清除的话容易产生内存无法释放(内存泄漏)的问题：value对应的对象即使不再使用，但由于被threadLocalMap所引用导致无法被GC回收。
 *
 */
public class DemoThreadLocal {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return Thread.currentThread().getId();
        };
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){;
        protected String initialValue() {
            return Thread.currentThread().getName();
        };
    };
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }


    public static void main(String[] args) {

        DemoThreadLocal bool = new DemoThreadLocal();
        System.out.println(bool.getLong());
        System.out.println(bool.getString());
        bool.set();
        System.out.println(bool.getLong());
        System.out.println(bool.getString());

        Thread thread1 = new Thread(){
            public void run() {
                bool.set();
                System.out.println(bool.getLong());
                System.out.println(bool.getString());
            };
        };
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bool.getLong());
        System.out.println(bool.getString());

//        get()：线程获取该ThreadLocal对应的变量
//        set(T value)：线程设置该ThreadLocal对应的变量
//        remove()：线程移除该ThreadLocal
//        withInitial：这个一般在生成ThreadLocal时使用初始化变量
       //  特别需要注意的是，如果初始化ThreadLocal时没有使用withInitial初始化初始值，那么在get()时会返回空，
        // 在使用基本类型(long,int等)时需要特别注意因为装包拆包而造成的空指针问题。
        ThreadLocal<String> a = new ThreadLocal<String>();
        a.set("aa");
        ThreadLocal<String> c = new InheritableThreadLocal<>();
        c.set("cc");
        ThreadLocal<String> b = ThreadLocal.withInitial(() -> "bb");
        Thread thread22 = new Thread(){
            public void run() {
                System.out.println("a="+a.get());
                System.out.println("c="+c.get());
                System.out.println("b="+b.get());
                c.set("12123");
                System.out.println("c="+c.get());
            };
        };
        thread22.start();

        try {
            thread22.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("c="+c.get());
    }

}
