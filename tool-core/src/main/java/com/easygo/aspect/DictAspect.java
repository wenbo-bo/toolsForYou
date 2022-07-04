package com.easygo.aspect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.easygo.annotation.Dict;
import com.easygo.service.IDictSV;
import com.easygo.utils.ReflectHelper;
import com.easygo.utils.StringUtil;
import com.easygo.vo.Result;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 字典aop类
 * @Author: dangzhenghui
 * @Date: 2019-3-17 21:50
 * @Version: 1.0
 */
@Aspect
@Component
@Slf4j
public class DictAspect {
    @Autowired
    private IDictSV dictService;

    private static final String LIST = "List";

    private static final String ORG_JEECG = "org.jeecg";

    // 定义切点Pointcut
    @Pointcut("execution(public * org.jeecg.modules..*.*Controller.*(..))")
    public void excudeService() {
    }

    @Around(value = "excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object result = pjp.proceed();
        long time2 = System.currentTimeMillis();
        log.debug("获取JSON数据 耗时：" + (time2 - time1) + "ms");
        long start = System.currentTimeMillis();
        this.parseDictText(result);
        long end = System.currentTimeMillis();
        log.debug("解析注入JSON数据  耗时" + (end - start) + "ms");
        return result;
    }

    /**
     * 本方法针对返回对象为Result 的IPage的分页列表数据进行动态字典注入
     * 字典注入实现 通过对实体类添加注解@dict 来标识需要的字典内容,字典分为单字典code即可 ，table字典 code table text配合使用与原来jeecg的用法相同
     * 示例为SysUser   字段为sex 添加了注解@Dict(dicCode = "sex") 会在字典服务立马查出来对应的text 然后在请求list的时候将这个字典text，已字段名称加_dictText形式返回到前端
     * 例输入当前返回值的就会多出一个sex_dictText字段
     * {
     * sex:1,
     * sex_dictText:"男"
     * }
     * 前端直接取值sext_dictText在table里面无需再进行前端的字典转换了
     * customRender:function (text) {
     * if(text==1){
     * return "男";
     * }else if(text==2){
     * return "女";
     * }else{
     * return text;
     * }
     * }
     * 目前vue是这么进行字典渲染到table上的多了就很麻烦了 这个直接在服务端渲染完成前端可以直接用
     *
     * @param result
     */
    private void parseDictText(Object result) {
        if (result instanceof Result && ((Result) result).getResult() != null) {
            List<Object> items = new ArrayList<>();
            if (((Result) result).getResult() instanceof IPage) {
                for (Object record : ((IPage) ((Result) result).getResult()).getRecords()) {
                    items.add(setDictText(record, ReflectHelper.item(record)));
                }
                if (StringUtil.isNotEmpty(items)) {
                    ((IPage) ((Result) result).getResult()).setRecords(items);
                }
            } else if (((Result) result).getResult() instanceof List && !(((Result) result).getResult() instanceof JSONArray)) {
                for (Object record : (ArrayList) ((Result) result).getResult()) {
                    items.add(setDictText(record, ReflectHelper.item(record)));

                }
                if (StringUtil.isNotEmpty(items)) {
                    ((Result) result).setResult(items);
                }
            } else {
                items.add(setDictText(((Result) result).getResult(), ReflectHelper.item(((Result) result).getResult())));
                if (StringUtil.isNotEmpty(items)) {
                    ((Result) result).setResult(items.get(0));
                }
            }

        }
    }

    private Object setDictText(Object record, JSONObject item) {
        Field[] firstFields = ReflectHelper.getAllFields(record);
        if (firstFields.length == 0 || null == item) {
            return record;
        }

        for (Field field : firstFields) {
            String name = field.getName();
            if (field.getType().getSimpleName().equals(LIST)) {
                List list = ReflectHelper.getList(record, name);
                if (StringUtil.isEmpty(list)) {
                    continue;
                }
                List<JSONObject> jsonList = new ArrayList<>(list.size());
                log.info("字典list数据:{}", list);
                for (Object o : list) {
                    JSONObject item2 = ReflectHelper.item(o);
                    Field[] fields = ReflectHelper.getAllFields(o);
                    if (fields.length == 0) {
                        continue;
                    }
                    for (Field field2 : fields) {
                        trans(field2, item2);
                        //setDictText(o, item2);
                    }
                    jsonList.add(item2);
                    item.put(name, jsonList);
                }
            } else if (field.getType().getName().contains(ORG_JEECG)) {
                Object o = ReflectHelper.getObject(record, name);
                if (null == o) {
                    continue;
                }
                JSONObject item2 = ReflectHelper.item(o);
                Field[] fields = ReflectHelper.getAllFields(o);
                for (Field field2 : fields) {
                    trans(field2, item2);
                    //setDictText(o, item2);
                }
                item.put(name, item2);
            }
            trans(field, item);
        }
        return item;
    }

    private void trans(Field field, JSONObject item) {
        if (field.getAnnotation(Dict.class) != null) {
            String code = field.getAnnotation(Dict.class).dicCode();
            String key = String.valueOf(item.get(field.getName()));
            //翻译字典值对应的txt
            String textValue = translateDictValue(code, key);

            //log.debug(" 字典Val : " + textValue);
            //log.debug(" __翻译字典字段__ " + field.getName() + CommonConstant.DICT_TEXT_SUFFIX + "： " + textValue);
            item.put(field.getName() + "_dictText", textValue);
        }
        //date类型默认转换string格式化日期
        if (field.getType().getName().equals("java.util.Date") && field.getAnnotation(JsonFormat.class) == null && item.get(field.getName()) != null) {
            SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            item.put(field.getName(), aDate.format(new Date((Long) item.get(field.getName()))));
        }
    }

    /**
     * 翻译字典文本
     *
     * @param code
     * @param key
     * @return
     */
    private String translateDictValue(String code, String key) {
        if (StringUtil.isEmpty(key)) {
            return null;
        }
        StringBuilder textValue = new StringBuilder();
        String[] keys = key.split(",");
        for (String k : keys) {
            String tmpValue = null;
            log.debug(" 字典 key : " + k);
            if (k.trim().length() == 0) {
                continue; //跳过循环
            }
            tmpValue = dictService.queryDictTextByKey(code, k.trim());
            if (tmpValue != null) {
                if (!"".equals(textValue.toString())) {
                    textValue.append(",");
                }
                textValue.append(tmpValue);
            }
        }
        return textValue.toString();
    }

}
