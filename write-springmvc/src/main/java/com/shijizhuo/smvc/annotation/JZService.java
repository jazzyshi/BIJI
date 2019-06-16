package com.shijizhuo.smvc.annotation;

import java.lang.annotation.*;

/**
 * Created by jzshi on 2019/6/16.
 */
@Target({ElementType.TYPE}) //表示类级别
@Retention(RetentionPolicy.RUNTIME)
@Documented //@Documented注解标记的元素，Javadoc工具会将此注解标记元素的注解信息包含在javadoc中。默认，注解信息不会包含在Javadoc中。
public @interface JZService {

    String value() default "";

}
