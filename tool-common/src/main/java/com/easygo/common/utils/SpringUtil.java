package com.easygo.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 静态存储Bean对象，方便调用
 *
 * @author: wenbo
 * @version: 2019年04月28日 17:12
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContextParam) throws BeansException {
        applicationContext = applicationContextParam;
    }

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
