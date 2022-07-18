package com.easygo.core.service;


import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author wenbo
 * @Date 2022/3/30 14:51
 **/
public interface IDictSV {


    /**
     * 需要自己从数据库查询实现 map ,存放值规格是 key=字典值 value = 目标值
     * eg: map.put("1","男")
     * 该查询可以做缓存 但是要注意的是不能使用  @Cacheable()注解 ,
     * 因为调用方是拦截器,注解方式会失效
     * redis 缓存使用 eg:redisTemplate.opsForValue().set(key, value); 即可
     *
     * @param dictCode 字典的查询标识dictCode
     * @return
     */

    default Map<String, String> getDictValues(String dictCode) {
        return null;
    }

    /**
     * @param dictCode 字典的枚举dictCode
     * @param keyType  Map返回Key的类型
     * @param <T>
     * @return
     */
    default <T> Map<T, String> getDictValues(String dictCode, Class<T> keyType) {
        Map<T, String> map = new LinkedHashMap<>();
        Map<String, String> dictValues = this.getDictValues(dictCode);
        dictValues.forEach((code, value) -> {
            T key = null;
            if (keyType == Integer.class) {
                key = (T) Integer.valueOf(code);
            } else if (keyType == String.class) {
                key = (T) String.valueOf(code);
            } else if (keyType == Double.class) {
                key = (T) Double.valueOf(code);
            } else if (keyType == Long.class) {
                key = (T) Long.valueOf(code);
            } else if (keyType == BigDecimal.class) {
                key = (T) new BigDecimal(code);
            }
            map.put(key, value);
        });
        return map;
    }


    default String queryDictTextByKey(String code, String trim) {
        return null;
    }
}
