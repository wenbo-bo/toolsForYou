package com.easygo.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类描述:  字典注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dict {
    /**

     * @return 返回类型： String
     */
    String dicCode();

    /**
     * @return 返回类型： String
     */
    String dicText() default "";

    /**
     * @return 返回类型： String
     */
    String dictTable() default "";
}
