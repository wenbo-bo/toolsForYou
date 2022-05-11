package com.easy.go.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collections;


/**
 * @Author wenbo
 * @Date 2021/10/20 9:59
 **/
public class RedisLockUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLockUtil.class);

    /**
     * 成功标识
     */
    private static final Long SUCCESS = 1L;

    /**
     * 加锁lua脚本,不可重入,reqId只是为了解锁使用,代表当前线程在使用资源,给UUID比较好
     */
    private static final String SCRIPT_LOCK = "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then redis.call('pexpire', KEYS[1], ARGV[2]) return 1 else return 0 end";

    /**
     * 解锁lua脚本
     */
    private static final String SCRIPT_UNLOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    /**
     * 加锁脚本sha1值
     */
    private static final String SCRIPT_LOCK_SHA1 = Sha1Util.encrypt(SCRIPT_LOCK);

    /**
     * 解锁脚本sha1值
     */
    private static final String SCRIPT_UNLOCK_SHA1 = Sha1Util.encrypt(SCRIPT_UNLOCK);

    /**
     * 内部持有模板
     */
    private static RedisTemplate<Object,Object> redisTemplate;
    static {
        redisTemplate= new RedisTemplate<>();

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        RedisConnectionFactory connectionFactory = SpringUtil.getBean(RedisConnectionFactory.class);
        redisTemplate.setConnectionFactory(connectionFactory);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serializer.setObjectMapper(mapper);

        redisTemplate.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        RedisSerializer<String> keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.afterPropertiesSet();
    }
    /**
     * 尝试获取分布式锁
     *
     * @param lockKey 锁
     * @param requestId 请求标识,唯一ID
     * @param expireTimeMilliseconds 超期时间，多少毫秒后这把锁自动释放
     * @return 返回true表示拿到锁
     */
    public static boolean tryGetDistributedLock(String lockKey, String requestId, long expireTimeMilliseconds) {
        LOGGER.info("[{}]尝试获取[{}]锁,超时时间为:{}毫秒", requestId, lockKey, expireTimeMilliseconds);
        /**
         * 脚本设置
         */
        RedisScript<Long> redisScript = new RedisScript<Long>() {
            @Override
            public String getSha1() {
                return SCRIPT_LOCK_SHA1;
            }

            @Override
            public Class<Long> getResultType() {
                return Long.class;
            }

            @Override
            public String getScriptAsString() {
                return SCRIPT_LOCK;
            }

        };
        Object result = redisTemplate.execute(
                redisScript,// lua脚本
                Collections.singletonList(lockKey),// KEYS[1]
                requestId, // ARGV[1]
                expireTimeMilliseconds // ARGV[2]
        );
        boolean b = SUCCESS.equals(result);
        LOGGER.info("获取锁:{}", b);
        return b;
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 返回true表示释放锁成功
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {
        LOGGER.info("[{}]释放锁[{}]锁", requestId, lockKey);

        /**
         * lua脚本
         */
        RedisScript<Long> redisScript = new RedisScript<Long>() {
            @Override
            public String getSha1() {
                return SCRIPT_UNLOCK_SHA1;
            }

            @Override
            public Class<Long> getResultType() {
                return Long.class;
            }

            @Override
            public String getScriptAsString() {
                return SCRIPT_UNLOCK;
            }

        };
        Object result = redisTemplate.execute(
                redisScript,
                Collections.singletonList(lockKey),
                requestId
        );
        boolean b = SUCCESS.equals(result);
        LOGGER.info("释放锁:{}", b);
        return b;
    }
}
