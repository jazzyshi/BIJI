package com.shijizhuo.smvc.annotation;

import java.lang.annotation.*;

/**
 * Created by jzshi on 2019/6/16.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JZRequestMapping {
    String value() default "";
}
