package com.easygo.sample.controller;

import com.easygo.common.vo.Result;
import com.easygo.sample.datasource.entities.DepotHead;
import com.easygo.sample.service.DepotHeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wenbo
 * @Date 2022/7/6 11:18
 **/
@Api(tags="仓储")
@RestController
@RequestMapping("/depotHead")
@Slf4j
public class DepotHeadController {

    @Resource
    private DepotHeadService depotHeadService;

    @ApiOperation(value = "仓储接口")
    @GetMapping("/list")
    public Result<?> listHead(){
        List<DepotHead> list = depotHeadService.list();
        return Result.successData(list);

    }
}
