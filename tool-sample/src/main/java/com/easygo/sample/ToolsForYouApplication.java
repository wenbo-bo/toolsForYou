package com.easygo.sample;


import com.easygo.core.annotation.Locker;
import com.easygo.core.aspect.LockerAspect;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.easygo.common.utils.ComputerInfo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import java.io.IOException;

/**
 * 启动类
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
@Slf4j
@MapperScan("com.easygo.sample.datasource.mappers")
@SpringBootApplication(scanBasePackages = {"com.easygo.sample"})
@EnableConfigurationProperties
public class ToolsForYouApplication {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(ToolsForYouApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        log.info("启动成功，后端服务API地址：http://" + ComputerInfo.getIpAddr() + ":"
                + environment.getProperty("server.port") + "/tools/doc.html");
    }
}
