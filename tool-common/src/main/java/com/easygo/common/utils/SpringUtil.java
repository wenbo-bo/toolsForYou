package com.easygo.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 静态存储Bean对象，方便调用
 *
 * @author: wenbo
 * @version: 2019年04月28日 17:12
 */
public class SpringUtil {
    public static ApplicationContext applicationContext;

    public static Object getObject(String id) {
        Object object = null;
        object = applicationContext.getBean(id);
        return object;
    }

    public static <T> T getObject(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }

    public static Object getBean(String tClass) {
        return applicationContext.getBean(tClass);
    }

    public static <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }

    public static <T> T getBean(String name, Class<T> tClass) {
        return applicationContext.getBean(name, tClass);
    }

    public static String[] getBeanNamesForType(Class<?> tClass) {
        return applicationContext.getBeanNamesForType(tClass);
    }


    public static String[] getProfiles() {
        //获取环境
        Environment environment = applicationContext.getEnvironment();
        //这个获取的是配置的运行环境，如开发，测试，以及生产
        String[] activeProfiles = environment.getActiveProfiles();

        //这个获取的是当前项目默认的运行环境，一般设置为开发
        String[] defaultProfiles = environment.getDefaultProfiles();
        return activeProfiles;
    }

    public static String getProfile() {
        return getProfiles()[0];
    }

}
