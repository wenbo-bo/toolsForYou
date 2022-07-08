# toolsForYou

#### 介绍
项目字典翻译 工具  全局并发锁实现  后续多事务开发中

#### 软件架构
软件架构说明


#### 安装教程

1.  添加依赖
```
        <dependency>
            <groupId>com.easy.go</groupId>
            <artifactId>tool-core</artifactId>
            <version>0.5.7</version>
        </dependency>
```
2.  设置仓库下载地址
```
        <repository>
            <id>gitee-zwenbobo</id>
            <name>gitee-maven</name>
            <url>https://gitee.com/zwenbobo/tools-for-you/raw/dev/release</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
```
2.1 或者下载jar 打入本地仓库
```
下载地址:https://gitee.com/zwenbobo/tools-for-you/blob/dev/release/com/easy/go/tool-core/0.5.7/tool-core-0.5.7.jar
```


#### 使用说明(翻译使用)
    
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
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)