package com.jz.bigdata.other.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlCallable;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *TransmittableThreadLocal 是Alibaba开源的、
 * 用于解决 “在使用线程池等会缓存线程的组件情况下传递ThreadLocal” 问题的 InheritableThreadLocal 扩展。
 * 若希望 TransmittableThreadLocal 在线程池与主线程间传递，需配合 TtlRunnable 和 TtlCallable 使用。
 *
 * 下面是几个典型场景例子。
 * 分布式跟踪系统
 * 应用容器或上层框架跨应用代码给下层SDK传递信息
 * 日志收集记录系统上下文
 *
 * TransmittableThreadLocal 继承自 InheritableThreadLocal，
 * 这样可以在不破坏ThreadLocal 本身的情况下，
 * 使得当用户利用 new Thread() 创建线程时仍然可以达到传递InheritableThreadLocal 的目的。
 * 作者：沈渊
 * 链接：https://www.jianshu.com/p/e0774f965aa3
 *
 * TransmittableThreadLocal 相比较 InheritableThreadLocal
 * 很关键的一点改进是引入holder变量，这样就不必对外暴露Thread中的
 * inheritableThreadLocals(参考InheritableThreadLocal详解)，保持ThreadLocal.ThreadLocalMap的封装性。
 *https://github.com/alibaba/transmittable-thread-local
 *
 * 使用方法：
 * 1.简单使用 父线程传值给子线程
 * 2.保证线程池中值传递
 *   2.1修饰Runnable和callable:使用TtlRunnable和TtlCallable来修饰传入线程池的Runnable和Callable
 *   2.2修饰线程池：省去每次Runnable和Callable传入线程池的修饰，这个逻辑可以在线程池中完成
 *      通过工具类TtlExecutors完成
 *      getTtlExecutor：修饰接口Executor
 *      getTtlExecutorService：修饰接口ExecutorService
 *      getTtlScheduledExecutorService：修饰接口ScheduledExecutorService
 *   2.3使用java agent 来修饰JDK线程池实现类：无侵入
 *   这种方式，实现线程池的传递是透明的，业务代码中没有修饰Runnable或是线程池的代码。即可以做到应用代码 无侵入。
 *    因为修饰了JDK标准库的类，标准库由bootstrap class loader加载；修饰后的JDK类引用了TTL的代码，所以Java Agent使用方式下TTL Jar文件需要配置到boot class path上。
 */
public class DemoTransmittableThreadLocal {
    public static void main(String[] args) throws Exception {
        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<String>();
        context.set("parent-value");

        //简单使用 -父线程传值给子线程
        new Thread(()->{
            System.out.println(context.get());
        }).start();
        System.out.println(context.get());
        //修饰Runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(context.get());
            }
        };
        //额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(ttlRunnable);
        //修饰Callable
        Callable call = new Callable() {
            @Override
            public Object call() throws Exception {
                return context.get();
            }
        };
        Callable ttlcall = TtlCallable.get(call);
        executorService.submit(ttlcall);
        System.out.println(ttlcall.call());
        //额外的处理，生成了修饰了的对象executorService
        executorService = TtlExecutors.getTtlExecutorService(executorService);
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(context.get());
            }
        };
        executorService.execute(task1);
        executorService.shutdown();
    }
}
