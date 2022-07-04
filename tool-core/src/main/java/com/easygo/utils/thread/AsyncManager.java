package com.easygo.utils.thread;

import com.easygo.utils.SpringUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务管理器
 */
public class AsyncManager {
    /**
     * 操作延迟2000毫秒
     */
    private final int OPERATE_DELAY_TIME = 2000;

    /**
     * 异步操作任务调度线程池
     */
    private ScheduledExecutorService executor = SpringUtil.getBean(ScheduledExecutorService.class);

    /**
     * 单例模式
     */
    private static final AsyncManager me = new AsyncManager();

    private AsyncManager() {

    }

    public static AsyncManager me() {
        return me;
    }

    /**
     * 执行任务
     *
     * @param task 任务
     */
    public void execute(Runnable task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 延时周期执行任务
     *
     * @param task 任务
     */
    public void executeWithFixedDelay(Runnable task, long period) {
        executor.scheduleWithFixedDelay(task, OPERATE_DELAY_TIME, period, TimeUnit.MILLISECONDS);
    }


    /**
     * 执行任务
     *
     * @param task 任务
     */
    public <T> ScheduledFuture<T> submit(Callable<T> task) {
        return executor.schedule(task, 1L, TimeUnit.MILLISECONDS);
    }


    /**
     * 停止任务线程池
     */
    public void shutdown() {
        Threads.shutdownAndAwaitTermination(executor);
    }


}
