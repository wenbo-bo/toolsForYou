package com.easygo.core.config;

import com.easygo.core.annotation.DictEntity;
import com.easygo.core.annotation.DictField;
import com.easygo.core.service.IDictSV;
import com.easygo.common.utils.SpringUtil;
import com.easygo.common.utils.StringUtil;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Statement;
import java.util.*;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * 处理枚举字段
 *
 * @author: wenbo
 * @version: 2019年04月28日 14:57
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = Statement.class)
})
public class MyBatisEnumHandlePlugin implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object proceed = invocation.proceed();
        if (proceed instanceof List) {
            List data = (List) proceed;
            if (StringUtil.isEmpty(data)) {
                return proceed;
            } else if (data.get(0) == null) {
                return Collections.emptyList();
            }
            // 对第一个对象进行分析
            List<Map<String, Object>> translationInformation = getTranslationInformation(data.get(0).getClass());
            // 如果没有字典标识,直接返回
            if (translationInformation.isEmpty()) {
                return proceed;
            }
            // 遍历结果进行设置翻译值
            for (Object datum : data) {
                for (Map<String, Object> info : translationInformation) {
                    Field readField = (Field) info.get("read");
                    Field writeField = (Field) info.get("write");
                    Map dictValues = (Map) info.get("value");
                    if (StringUtil.isEmpty(readField.get(datum))) {
                        continue;
                    }
                    FieldUtils.writeField(writeField, datum, dictValues.get(readField.get(datum)), true);
                }
            }
            return data;
        }
        return proceed;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 通过类,获取需要翻译的字段信息
     *
     * @param cls
     * @return
     */
    private List<Map<String, Object>> getTranslationInformation(Class<?> cls) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 查询字典值service

        IDictSV iDictSV = SpringUtil.getBean(IDictSV.class);
        //Method getDictValues = IDictSV.class.getMethod("getDictValues",String.class, Class.class);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<DictField> dicts = new ArrayList<DictField>();
        getAllDictAnnotation(cls, dicts);
        if (dicts.isEmpty()) {
            return list;
        }
        Set<DictField> set = new HashSet<DictField>(dicts);
        for (Iterator<DictField> iterator = set.iterator(); iterator.hasNext(); ) {
            DictField dictField = iterator.next();
            // 开始填充Field
            // 字典读写翻译信息存储
            Map<String, Object> fieldInfo = new HashMap<String, Object>();
            String toField = dictField.to();
            if ("".equals(toField)) {
                //如果没有设置，默认为From()+Name
                toField = dictField.from() + "Name";
            }
            Field readField = FieldUtils.getField(cls, dictField.from(), true);
            Field writeField = FieldUtils.getField(cls, toField, true);
            //Map localValue = dictSV.getDictValues(dictField.enumClass(), dictField.codeType());
            //IDictSV iDictSV = new DictSVImpl();
            Map localValue = iDictSV.getDictValues(dictField.dictCode(), dictField.codeType());
            //Map localValue = (Map) getDictValues.invoke(iDictSV,dictField.dictCode(), dictField.codeType());
            if (readField == null || writeField == null || localValue == null) {
                continue;
            }
            fieldInfo.put("read", readField);
            fieldInfo.put("write", writeField);
            fieldInfo.put("value", localValue);
            list.add(fieldInfo);
        }
        return list;
    }


    /**
     * 获取所有的字典注解
     *
     * @param cls    类信息
     * @param fields 存放值
     */
    private void getAllDictAnnotation(Class<?> cls, List<DictField> fields) {
        DictEntity annotation = cls.getAnnotation(DictEntity.class);
        // 加入注解
        if (annotation != null) {
            DictField[] value = annotation.value();
            fields.addAll(Arrays.asList(value));
        }
        // 继续往上找
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            getAllDictAnnotation(cls.getSuperclass(), fields);
        }
    }
}

