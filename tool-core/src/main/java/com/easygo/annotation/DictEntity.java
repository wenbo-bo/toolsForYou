package com.easygo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识是一个含有数据字典的实体
 *
 * @author: wenbo
 * @version: 2019年04月28日 12:30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DictEntity {
    DictField[] value();
}
