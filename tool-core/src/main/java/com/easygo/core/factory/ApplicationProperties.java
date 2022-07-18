package com.easygo.core.factory;

import com.easygo.common.utils.SpringUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wenbo
 * @Date 2022/6/22 15:01
 **/
public class ApplicationProperties implements ApplicationContextAware, InitializingBean {

    /**
     * spring上下文
     */
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
        this.applicationContext = applicationContext;
    }
}
