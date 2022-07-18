package com.easygo.sample.config.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.easygo.common.utils.SpringUtil;
import com.easygo.core.config.MyBatisEnumHandlePlugin;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 配置枚举翻译插件
 *
 * @author: wenbo
 * @version: 2019年04月28日 15:23
 */
@Component
public class MybatisPluginConfig implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args){
        SqlSessionFactory sqlSessionFactory = SpringUtil.getObject(SqlSessionFactory.class);
        sqlSessionFactory.getConfiguration().addInterceptor(new MyBatisEnumHandlePlugin());

    }

    /**
     * 新的分页插件（推荐）
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
