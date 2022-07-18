package com.easygo.sample.datasource.mappers;

import java.util.List;
import java.util.Map;

public interface SysDictMapperEx {
    /**
     * 获取数据字典的值,
     *
     * @param dictCode 力度大
     * @return
     */
    List<Map<String, String>> getDictValues(String dictCode);
}