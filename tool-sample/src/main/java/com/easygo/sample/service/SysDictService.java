package com.easygo.sample.service;

import com.easygo.core.service.IDictSV;

import com.easygo.sample.datasource.mappers.SysDictMapperEx;
import com.easygo.sample.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wenbo
 * @Date 2021/12/2 16:30
 **/
@Service
@Slf4j
public class SysDictService implements IDictSV {

    @Autowired
    private SysDictMapperEx dictMapperExt;


    @Autowired
    private RedisUtil redisUtil;

    //@Cacheable(value = "SysDictCache", key = "#dictCode+':'+'Double'+':ALL'", unless = "#result == null ")
    @Override
    public Map<String, String> getDictValues(String dictCode) {
        Map<String, String> map = (Map<String, String>)redisUtil
                .get("easygo:dict:"+dictCode);
        List<Map<String, String>> dictValues = null;
        if (null == map){
            dictValues = dictMapperExt.getDictValues(dictCode);
            if (!dictValues.isEmpty()) {
                map = new LinkedHashMap<>();
                for (Map<String, String> dictValue : dictValues) {
                    map.put(dictValue.get("code"), dictValue.get("value"));
                }
            }
            redisUtil.set("easygo:dict:"+dictCode,map);
        }
        return map;
    }


}
