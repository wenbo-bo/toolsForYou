package com.easygo.sample.controller;

import com.alibaba.fastjson.JSONObject;
import com.easygo.common.utils.SpringUtil;
import com.easygo.common.vo.Result;
import com.easygo.core.annotation.Locker;
import com.easygo.core.aspect.LockerAspect;
import com.easygo.sample.datasource.entities.DepotHead;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wenbo
 * @Date 2022/7/4 18:30
 **/

@Api(tags="测试")
@RestController
@RequestMapping("/sample")
@Slf4j
public class TestController {

    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public Result<?> test(){
        return Result.ok("成功!");

    }

    @GetMapping("/lockerGet")
    @ApiOperation("测试锁")
    @Locker(paramExp = "0#param+1#param2")
    public Result<?> lockerGet(
            @RequestParam String param,
            @RequestParam String param2){
        System.out.println(param);
        return Result.ok("成功");
    }

    @PostMapping("/lockerPost")
    @ApiOperation("测试锁")
    @Locker(paramExp = "0#number+0#defaultNumber")
    public Result<?> lockerPost(@RequestBody DepotHead depotHead){
        System.out.println(depotHead);
        LockerAspect bean = SpringUtil.getBean(LockerAspect.class);
        return Result.ok();

    }

    @PostMapping(value = "/lockerPost2",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiOperation("测试锁")
    @Locker(paramExp = "0#a+1#b")
    public Result<?> lockerGet2(String a,String b){
        System.out.println(a);
        return Result.ok();

    }


    @PostMapping("/jsonPost")
    @ApiOperation("测试锁")
    @Locker(paramExp = "0#number+0#defaultNumber")
    public Result<?> jsonPost(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        return Result.ok();

    }

}
