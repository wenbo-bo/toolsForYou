package com.easygo.core.annotation;

import java.lang.annotation.*;

/**
 * @Author wenbo
 * @Date 2021/3/2 15:02
 **/

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultiTransactional {

    String[] value() default {};
}
