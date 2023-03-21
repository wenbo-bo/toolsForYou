package com.easygo.core.aspect;


import com.alibaba.fastjson.JSONObject;
import com.easygo.common.utils.StringUtil;
import com.easygo.core.annotation.Locker;
import com.easygo.common.utils.CommonUtils;
import com.easygo.common.utils.RedisLockUtil;
import com.easygo.common.utils.ReflectHelper;

import com.easygo.common.utils.thread.Threads;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @Author wenbo
 * @Date 2021/10/20 10:17
 **/

@Aspect
@Order(2)
@Component
public class LockerAspect {


    private static Logger LOGGER = LoggerFactory.getLogger(LockerAspect.class);

    @Pointcut("@annotation(com.easygo.core.annotation.Locker)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("持有锁的方法{}", joinPoint.getSignature());
        Object proceed = null;
        long startTime = System.currentTimeMillis();
        Locker locker = getAnnotation(joinPoint, Locker.class);
        Object[] args = joinPoint.getArgs();
        // 最大尝试次数
        int maxGetNum = locker.maxGetNum();
        // 会话标志
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 锁key
        String lockFiled = getLockFiled(args, locker.paramExp());
        String lockKey = CommonUtils.keyBuilder(locker.key(), lockFiled);
        // 过期时间
        long expireTime = locker.expireTime();
        boolean lock = RedisLockUtil.tryGetDistributedLock(lockKey, uuid, expireTime);
        int getNum = 0;
        while (!lock && locker.continueGet() && (maxGetNum == 0 || getNum < maxGetNum)) {
            // 如果获取失败，且持续获取，且尝试次数小于最大次数
            Threads.sleep(100);
            lock = RedisLockUtil.tryGetDistributedLock(lockKey, uuid, expireTime);
        }
        if (!lock) {
            throw new RuntimeException(locker.noGetMsg());
        }
        // -------------------------------before-------------------------
        try {
            proceed = joinPoint.proceed();
            // -------------------------------after-------------------------
            // 如果业务时间小于最小持有锁时间，休眠一会
            long limitTime = locker.limitTime();
            long doTime = System.currentTimeMillis() - startTime;
            long sleepTime = limitTime - doTime;
            LOGGER.info("业务耗时: {} 毫秒 锁时间: {} 毫秒", doTime, limitTime);
            if (sleepTime > 0) {
                Threads.sleep(sleepTime);
            }
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        } finally {
            // 释放锁
            RedisLockUtil.releaseDistributedLock(lockKey, uuid);
        }
        return proceed;
    }

    /**
     * 根据表达式获取要锁的字段
     * 0#name+1#name?payOrder 表示第一个参数的name字段+第二个参数的name字段，且额外拼接锁定的Key为payOrder
     *
     * @param args
     * @param expression 表达式
     * @return
     */
    private String getLockFiled(Object[] args, String expression) {
        if (args == null || args.length == 0 || StringUtil.isEmpty(expression)) {
            throw new UnsupportedOperationException("Locker所在方法参数为空! 请使用代码锁");
        }
        //Long userId = 0L;
        //userId = ShiroUtil.getCurrentAppUser(true) == null ? userId:ShiroUtil.getCurrentAppUser(true).getId();
        String[] extraParams = expression.split("\\?");
        String extraKey = null;
        if (extraParams.length > 1) {
            extraKey = extraParams[1];
            expression = extraParams[0];
        }
        String[] commboExpression = expression.split("\\+");
        StringBuilder field = new StringBuilder();
        for (String commbo : commboExpression) {
            String[] split = commbo.split("#");
            int argsNum = 0;
            try {
                Object o = null;
                argsNum = Integer.parseInt(split[0]);
                o = args[argsNum];
                appendValue(o, split, field);
            } catch (Exception e) {
                LOGGER.info("LockFiled e:{}", e.getMessage());
                throw new UnsupportedOperationException("Locker表达式paramExp不正确！");
            }
        }
        if (field.length() != 0 && extraKey != null) {
            field.append(extraKey);
        }
        return field.toString();
    }

    private void appendValue(Object o, String[] split, StringBuilder field) {
        Object fieldValue = null;
        if (o instanceof JSONObject) {
            fieldValue = ((JSONObject) o).get(split[1]);
            field.append(fieldValue);
        } else if (argType(o)) {
            fieldValue = o;
            field.append(fieldValue);
        } else {
            fieldValue = ReflectHelper.getFieldValue(o, split[1]);
            field.append(fieldValue);
        }
    }

    private boolean argType(Object arg) {
        return (arg instanceof String || arg instanceof Number || arg instanceof Enum || arg instanceof Boolean);
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private <T> T getAnnotation(JoinPoint joinPoint, Class<? extends Annotation> t) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return (T) method.getAnnotation(t);
        }
        return null;
    }

//
//    private String getRequestMethod() {
//        HttpServletRequest request = RequestUtils.getRequest();
//        return request == null ? "GET" : request.getMethod();
//    }
}
