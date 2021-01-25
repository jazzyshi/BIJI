package com.jz.bigdata.performancetuning;

/**
标准参数：
  1.-help
  2.-server -client
  3.-version -showversion
  4.-cp -classpath
 X参数
    1.非标准化参数
    2.-Xint：解释执行
    3.-Xcomp:第一次使用就编译成本地代码
    4.-Xmixed:混合执行，jvm自己来决定是否编译成本地代码
 XX参数
  1.非标准化参数
  2.相对不稳定
  3.主要用于JVM调优和Debug
  Boolean类型--格式：-XX:[+-]<name>表示启用或者禁用name属性
               比如： -XX:+UseConcMarkSweepGC  -XX:UseG1GC
  非Boolean类型--格式：-XX:<name>=<value>表示name属性的值是value
               比如：-XX:MaxGCPauseMillis=500
 **/
public enum DemoJVM {

    //-Xms等价于-XX:InitialHeapSize
    //-Xmx等价于-XX:MaxHeapSize  最大堆大小

    //查看JVM运行时参数
    //-XX:+PrintFlagsInitial 查看初始值
    //-XX:+PrintFlagsFinal   查看最终值
    //-XX:+UnlockExperimentalVMOptions解锁实验参数
    //-XX:+UnlockDiagnosticVMOptions解锁诊断参数
    //-XX:+PrintCommandLineFlags打印命令行参数
    /*举例：
    C:\Users\jazzyshi>java -XX:+PrintFlagsFinal -version
    [Global flags]
        uintx AdaptiveSizeDecrementScaleFactor          = 4                                   {product}
        uintx AdaptiveSizeMajorGCDecayTimeScale         = 10                                  {product}
        uintx AdaptiveSizePausePolicy                   = 0                                   {product}
        uintx InitialHeapSize                          := 268435456                           {product}
        bool UseG1GC                                   = false                               {product}
     */

    /*
    jinfo -flag MaxHeapSize 22121 查看最大堆内存
    jinfo -falg UseG1GC 22121      +(代表使用) -(代表未使用)
     */

    /*
    jstat查看jvm统计信息：类加载、垃圾回收、JIT编译
    jstat -help|-options
    options:  -class -gc -compiler -printcompilation
    垃圾收集： -gc,-gccause ,-gcnew，-gcoption
     */

    /*
    如何导出内存映像文件
    1.内存溢出时自动导出： -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
    2.使用jmap命令手动导出 ： jmap -dump:format=b,file=heap.hprof 16940 (还有其它参数，自己-help)

    分析：MAT
     */

    /*
    jtack死循环与死锁
    jstack 121212 > 1.txt
    实战死循环导致cpu标高
     */

    /*
    java VisualVM !!!!集成了很多命令
     */

    /*
     BTrace简介
     Btrace可以动态地向目标应用程序的字节码注入追踪代码
     JavaCompilerApi、JVMTI、Agent、Instrumentation+ASM

     拦截方法： 普通方法 @OnMethod(clazz="",method="")
               构造方法 @OnMethod(clazz="",method="<init>")
               拦截同名函数，用参数区分
     拦截时机： Kind.ENTRY:入口，默认值
               Kind.RETURN:返回
               Kind.THROW:异常
               Kind.Line：行
     拦截this、参数、返回值：
               this:@Self
               入参：可以用AnyType,也可以用真实类型，同名的用真实的
               返回：@Return

     获取对象的值：简单类型：直接获取
                 复杂类型：反射，类名+属性名

      注意事项：1.默认只能本地运行
               2.生产环境下可以使用，但是被修改的字节码不会被还原
     */
}
