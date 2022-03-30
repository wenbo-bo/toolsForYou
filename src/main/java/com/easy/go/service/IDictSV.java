package com.easy.go.service;

import java.util.Map;

/**
 * @Author wenbo
 * @Date 2022/3/30 14:51
 **/
public interface IDictSV {

    /**
     * 根据Key获取数据字典的多个值
     *
     * @param dictCode 字典的枚举dictCode
     * @return
     */
    Map<String, String> getDictValues(String dictCode);

    /**
     * 根据Key获取数据字典的多个值
     *
     * @param dictCode 字典的枚举dictCode
     * @param keyType  Map返回Key的类型
     * @param <T>
     * @return
     */
    <T> Map<T, String> getDictValues(Class<?> dictCode, Class<T> keyType);
}
