package com.easygo.sample.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easygo.sample.datasource.entities.DepotHead;
import com.easygo.sample.datasource.mappers.DepotHeadMapperEx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wenbo
 * @Date 2022/7/6 11:41
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DepotHeadService extends ServiceImpl<DepotHeadMapperEx, DepotHead> {
}
