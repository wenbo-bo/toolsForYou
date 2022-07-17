package com.easygo.core.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;

import com.sun.nio.file.ExtendedWatchEventModifier;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import com.easygo.common.utils.StringUtil;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.*;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * mybatis热部署插件
 * 设置mybatis配置文件cache-enabled: false不缓存，开启热部署xml
 *
 * @author:文博
 * @version: 2021年03月28日 14:10
 */
public class MapperHotDeployPlugin implements InitializingBean, ApplicationContextAware {

    private final static Logger logger = LoggerFactory.getLogger(MapperHotDeployPlugin.class);


    private MybatisProperties mybatisProperties;

    private MybatisPlusProperties mybatisPlusProperties;

    private Configuration configuration;

    private boolean mybatisPlus;

    private static final String[] MAPPER_METHOD =
            {"insert", "deleteById", "deleteByMap", "delete", "deleteBatchIds", "updateById", "update", "selectById", "selectBatchIds", "selectByMap", "selectOne", "selectCount", "selectList", "selectMaps", "selectObjs", "selectPage", "selectMapsPage"};

    private static final String [] MYBATIS_XML = {"mappedStatements", "caches", "resultMaps", "parameterMaps", "keyGenerators", "sqlFragments"};

    private static final String MAPPED_STATEMENTS = MYBATIS_XML[0];

    private static final String LOADED_RESOURCES  = "loadedResources";

    private Resource[] resources;


    @Override
    public void afterPropertiesSet() {
        // 设置mybatis配置文件cache-enabled: false不缓存，开启热部署xml
		if (null != configuration && !configuration.isCacheEnabled()) {
            WatchThread watchThread = new WatchThread();
            //watchThread.setDaemon(true);
            watchThread.setName("WatchThread -");
            watchThread.start();
		}else {
            logger.info("未配置 任何mybatis的相关配置");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        mybatisPlusProperties = applicationContext.getBean(MybatisPlusProperties.class);
        mybatisProperties = applicationContext.getBean(MybatisProperties.class);
        if (null != mybatisPlusProperties.getConfiguration()){
            this.configuration = mybatisPlusProperties.getConfiguration();
            resources = mybatisPlusProperties.resolveMapperLocations();
            mybatisPlus = true;
        }else {
            this.configuration = mybatisProperties.getConfiguration();
            resources = mybatisProperties.resolveMapperLocations();
        }


    }

    class WatchThread extends Thread {
        private final Logger logger = LoggerFactory.getLogger(WatchThread.class);

        @Override
        public void run() {
            startWatch();
        }


        /**
         * 启动监听
         */
        private void startWatch() {
            Set<String> watchPaths = getWatchPaths();
            try {
                WatchService watcher = FileSystems.getDefault().newWatchService();
                watchPaths.forEach(p -> {
                    try {
                        Paths.get(p).register(watcher,
                                StandardWatchEventKinds.ENTRY_MODIFY,
                                StandardWatchEventKinds.ENTRY_DELETE,
                                StandardWatchEventKinds.ENTRY_CREATE,
                                StandardWatchEventKinds.OVERFLOW);
                    } catch (Exception e) {
                        logger.error("ERROR: 注册xml监听事件", e);
                        throw new RuntimeException("ERROR: 注册xml监听事件", e);
                    }
                });
                Set<String> set = new HashSet<>();
                while (true) {
                    set.clear();
                    WatchKey watchKey = watcher.take();
                    for (WatchEvent<?> event : watchKey.pollEvents()) {
                        set.add(event.context().toString());
                    }
                    // 重新加载xml
                    reloadXml(set);
                    watchKey.reset();
                }
            }catch (Exception e){
                logger.info("Mybatis的xml监控失败!", e);
            }
        }

        /**
         * 加载需要监控的文件父路径
         */
        private Set<String> getWatchPaths() {
            Set<String> set = new HashSet<>();
            Arrays.stream(resources).forEach(r -> {
                try {
                    //logger.info("资源路径:{}", r.toString());
                    set.add(r.getFile().getParentFile().getAbsolutePath());
                } catch (Exception e) {
                    logger.info("获取资源路径失败", e);
                }
            });
            logger.info("需要监听的xml资源: {}", set);
            return set;
        }

        /**
         * 获取配置的mapperLocations
         */
//        private Resource[] getResource() {
//            return mybatisProperties.resolveMapperLocations();
//        }

        /**
         * 删除mybatisPlus xml元素的节点缓存
         * "mappedStatements",
         */
        private void clearPlusMap(String nameSpace) {
            logger.info("清理Mybatis的namespace={}在mappedStatements、caches、resultMaps、parameterMaps、keyGenerators、sqlFragments中的缓存",nameSpace);
            Arrays.asList(MYBATIS_XML).forEach(fieldName -> {
                Object value = getFieldValue(configuration, fieldName);
                if (value instanceof Map && StringUtil.isNotEmpty((Map) value)) {
                    Map<?, ?> map = (Map) value;
                    map.remove("BaseResultMap");
                    List<Object> list = map.keySet().stream().filter(o -> o.toString().startsWith(nameSpace + ".")).collect(Collectors.toList());
                    if (MAPPED_STATEMENTS.equals(fieldName)) {
                        Iterator<Object> it = list.iterator();
                        while (it.hasNext()) {
                            Object o = it.next();
                            for (String s : MAPPER_METHOD) {
                                if ((nameSpace + "." + s).equals(o)) {
                                    it.remove();
                                }
                            }
                        }
                    }
                    if (StringUtil.isEmpty(list)){
                        return;
                    }
                    logger.info("需要清理的元素: {}", list);
                    list.forEach(
                            k -> {
                                map.remove((Object)k);
                                //System.out.println("===="+k);
                            }
                    );
                }
            });
        }

        /**
         * 删除mybatisXml元素的节点缓存
         * "mappedStatements",
         */
        private void clearMap(String nameSpace) {
            if (StringUtil.isEmpty(nameSpace)){
                return;
            }
            logger.info("清理Mybatis的namespace={}在mappedStatements、caches、resultMaps、parameterMaps、keyGenerators、sqlFragments中的缓存",nameSpace);
            Arrays.asList(MYBATIS_XML).forEach(fieldName -> {
                Object value = getFieldValue(configuration, fieldName);
                if (value instanceof Map && StringUtil.isNotEmpty((Map) value)) {
                    Map<?, ?> map = (Map) value;
                    List<Object> list = map.keySet().stream().filter(o -> o.toString().startsWith(nameSpace + ".")).collect(Collectors.toList());
                    if (StringUtil.isEmpty(list)){
                        return;
                    }
                    logger.info("需要清理的元素: {}", list);
                    list.forEach(k -> map.remove((Object) k));
                }
            });
        }

        /**
         * 清除文件记录缓存
         */
        private void clearSet(String resource) {
            logger.info("清理mybatis的资源{}在容器中的缓存", resource);
            Object value = getFieldValue(configuration, LOADED_RESOURCES);
            if (value instanceof Set && StringUtil.isNotEmpty((Set)value)) {
                Set<?> set = (Set) value;
                set.remove(resource);
                set.remove("namespace:" + resource);
            }
        }

        /**
         * 获取对象指定属性
         *
         * @param obj       对象信息
         * @param fieldName 属性名称
         */
        private Object getFieldValue(Object obj, String fieldName) {
            logger.info("从{}中加载{}属性", obj, fieldName);
            try {
                Field field = null;
                if (mybatisPlus && LOADED_RESOURCES.equals(fieldName)){
                    field =  obj.getClass().getSuperclass().getDeclaredField(fieldName);
                }else {
                    field =  obj.getClass().getDeclaredField(fieldName);
                }
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                Object value = field.get(obj);
                field.setAccessible(accessible);
                return value;
            } catch (Exception e) {
                logger.info("ERROR: 加载对象中[{}]", fieldName, e);
                return null;
            }
        }

        /**
         * 重新加载set中xml
         *
         * @param set 修改的xml资源
         */
        private void reloadXml(Set<String> set) {
            List<Resource> list = Arrays.stream(resources)
                    .filter(p -> set.contains(p.getFilename()))
                    .collect(Collectors.toList());
//            if (StringUtil.isEmpty(list)){
//                return;
//            }
            logger.info("需要重新加载的文件列表: {}", set);
            logger.info("需要处理的资源路径:{}", list);
            final String[] namespace = {null};
            list.forEach(r -> {
                try {
                    namespace[0] = getNamespace(r);
                    if (mybatisPlus){
                        clearPlusMap(namespace[0]);
                    }else {
                        clearMap(namespace[0]);
                    }
                    clearSet(r.toString());
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(r.getInputStream(), configuration,
                            r.toString(), configuration.getSqlFragments());
                    xmlMapperBuilder.parse();
                } catch (Exception e) {
                    logger.info("ERROR: 重新加载[{}]失败", r.toString(), e);
                } finally {
                    ErrorContext.instance().reset();
                }
            });
            logger.info("成功热部署文件列表: {}", set);
        }

        /**
         * 获取xml的namespace
         *
         * @param resource xml资源
         */
        private String getNamespace(Resource resource) {
            logger.info("从{}获取namespace", resource.toString());
            try {
                XPathParser parser = new XPathParser(resource.getInputStream(), true, null, new XMLMapperEntityResolver());
                return parser.evalNode("/mapper").getStringAttribute("namespace");
            } catch (Exception e) {
                logger.info("ERROR: 解析xml中namespace失败", e);
                return null;
            }
        }
    }
}
