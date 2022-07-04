package com.easygo.core.annotation;


import java.lang.annotation.*;

/**
 * 标识是一个含有数据字典的实体
 *
 * @author: wenbo
 * @version: 2019年04月28日 12:30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = DictEntity.class)
public @interface DictField {

    /**
     * 要翻译的字段名称
     */
    String from();

    /**
     * 翻译到哪个字段.默认为from()+Name,可以自定义
     */
    String to() default "";

    /**
     * 查询的字典 key
     *
     * @return
     */
    String dictCode() default "";
//
//	/**
//	 * 枚举类
//	 */
//	Class<?> enumClass();

    /**
     * code类型
     */
    Class<?> codeType() default String.class;

}
