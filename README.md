# toolsForYou

#### 介绍
1.项目字典翻译 工具  
2.全局并发锁实现  
3.mybatis xml 热加载插件  
4.后续多事务开发中

#### 软件架构
软件架构说明


#### 安装教程

添加依赖
```
        <dependency>
            <groupId>io.gitee.zwenbobo</groupId>
            <artifactId>tool-core</artifactId>
            <version>0.5.7</version>
        </dependency>
```


#### 字典翻译使用配置
    
1.  实现字典接口
```
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
```
2. 在需要翻译的实体类上加上注解  
eg:
```
/**
*sex 数据库原字段
*sexName 翻译后加载到该字段 可以自定义
*/
@DictEntity({
        @DictField(dictCode = "sex",from = "sex",to = "sexName")
})
public class user{

/**
*数据库存储字段 1 或者 2
*/
private String sex;
/**
*
*该字段会被翻译成 男 或者 女
*/
private String sexName
}
```
#### 分布式并发锁
1.在需要控制并发的接口上加上注解 (比如下单接口) @Locker  
```
    @PostMapping("/lockerPost")
    @ApiOperation("测试锁")
    @Locker(paramExp = "0#number+0#defaultNumber")
    public Result<?> lockerPost(@RequestBody Order order){
        System.out.println(order);
        return Result.ok();

    }
```
1.1 接口支持各种形式 的入参
```
    @GetMapping("/lockerGet")
    @ApiOperation("测试锁")
    @Locker(paramExp = "0#param+1#param2")
    public Result<?> lockerGet(
            @RequestParam String param,
            @RequestParam String param2){
        System.out.println(param);
        return Result.ok("成功");
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
```
#### mybatis xml热部署
1. 在配置 mybatis 或者 mybatis-plus时 配置  cache-enabled: false 启用
不想使用 设置为true 本地可以禁用二级缓存 ,生产可以不需要热部署 开始二级缓存 且热部署失效
```
  configuration:
    cache-enabled: false
```
#### 多少数据源情况下多事务不同步解决(完善中)
1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

