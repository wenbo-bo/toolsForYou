package com.easygo.sample.controller;

import com.easygo.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
