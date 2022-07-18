//package com.easy.go.register;
//
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.ResourceLoaderAware;
//import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ResourceLoader;
//
///**
// * @Author wenbo
// * @Date 2022/6/22 16:34
// **/
//public class BeanRegistry implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {
//
//    private ResourceLoader resourceLoader;
//    private Environment environment;
//
//    @Override
//    public void setEnvironment(Environment environment) {
//
//    }
//
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//}