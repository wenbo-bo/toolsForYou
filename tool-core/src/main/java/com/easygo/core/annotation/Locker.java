package com.easygo.core.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author wenbo
 * @Date 2021/10/20 9:56
 **/


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Locker {

    /**
     * 要锁定的Key
     *
     * @return
     */
    String key() default "redis:Locker:global";

    /**
     * 要锁定的参数
     * 格式:
     * 0 表示一个参数toString
     * 0?payOrder 表示一个参数toString，且额外拼接锁定的Key为payOrder
     * 0#name 表示第一个参数的name字段
     * 0#name?payOrder 表示第一个参数的name字段，且额外拼接锁定的Key为payOrder
     * 0#name+1#name?payOrder 表示第一个参数的name字段+第二个参数的name字段，且额外拼接锁定的Key为payOrder
     *
     * @return
     */
    String paramExp();

    /**
     * 业务超时自动释放锁的时间,应该大于正常业务执行时间
     *
     * @return
     */
    long expireTime() default 10000;

    /**
     * 最小持有锁的时间
     *
     * @return
     */
    long limitTime() default 0;

    /**
     * 是否持续竞争锁
     *
     * @return
     */
    boolean continueGet() default false;

    /**
     * 最大竞争次数。默认0不限次
     *
     * @return
     */
    int maxGetNum() default 0;

    /**
     * 拿不到锁，异常返回信息
     *
     * @return
     */
    String noGetMsg() default "未获取锁";

}
