package com.easygo.sample.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * swagger
 *
 * @author wenbo
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    public final static String AUTH_TOKEN = "auth-token";

    @Bean(value = "createRestApi")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("toolsForYou")
                        .description("接口文档")
                        .termsOfServiceUrl("943013829@qq.com")
                        //.contact(new Contact("jiaoshiyilaio","","943013829@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("tools")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.easygo.sample.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securityScheme())
                .securityContexts(securityContexts());
    }

    /***
     * oauth2配置
     * 需要增加swagger授权回调地址
     * http://localhost:8888/webjars/springfox-swagger-ui/o2c.html
     * @return
     */

    private List<SecurityScheme> securityScheme() {
        return Collections.singletonList(
                new ApiKey(AUTH_TOKEN, AUTH_TOKEN, "header"));
    }

    private List<SecurityContext> securityContexts(){
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
        .securityReferences(defaultAuth())
        .build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global","");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferenceList = new ArrayList<>();
        securityReferenceList.add(new SecurityReference(AUTH_TOKEN,authorizationScopes));
        return securityReferenceList;
    }

    /**
     * JWT token
     * @return
     */
    private static List<RequestParameter> setHeaderToken() {
        //ParameterSpecification parameterSpecification = new ParameterSpecification();
        RequestParameter tokenPar = new RequestParameter(
                AUTH_TOKEN,ParameterType.HEADER,"token",true,
                true,true,null,null,null,1,null,1);
        List<RequestParameter> pars = new ArrayList<>();
        pars.add(tokenPar);
        return pars;
    }



}
