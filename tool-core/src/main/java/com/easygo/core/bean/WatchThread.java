package com.easygo.core.bean;

import com.easygo.common.utils.thread.Threads;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

/**
 * @Author wenbo
 * @Date 2022/7/14 18:20
 **/
public class WatchThread {
    /**
     * 单线程的 执行延时任务的 线程池
     *
     * @return
     */
    @Bean(name = "singleThreadScheduledExecutor")
    public ExecutorService newSingleThreadScheduledExecutor() {
        return Executors.newSingleThreadScheduledExecutor(
                new BasicThreadFactory.Builder().daemon(true).namingPattern("singleThreadScheduledExecutor-%d").build()
        );
    }

    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(10,
                new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build(),
                new RejectedExecutionHandler() {
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (Exception e) {
                            //异常会 调用 afterExecute(Runnable r, Throwable t);
                        }
                    }
                }) {

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                Threads.printException(r, t);
            }
        };
    }
}
