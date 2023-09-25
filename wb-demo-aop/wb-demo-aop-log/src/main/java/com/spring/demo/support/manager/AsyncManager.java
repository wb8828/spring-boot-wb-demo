package com.spring.demo.support.manager;


import cn.hutool.extra.spring.SpringUtil;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务管理器
 */
public class AsyncManager {
    private static AsyncManager ME = new AsyncManager();
    /**
     * 操作延迟10毫秒
     */
    private final int OPERATE_DELAY_TIME = 100;
    /**
     * 异步操作任务调度线程池
     */
    private final ScheduledExecutorService EXECUTOR = SpringUtil.getBean("scheduledExecutorService");

    /**
     * 单例模式
     */
    private AsyncManager() {
    }

    public static AsyncManager me() {
        return ME;
    }

    /**
     * 执行任务
     *
     * @param task 任务
     */
    public void execute(TimerTask task) {
        EXECUTOR.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 停止任务线程池
     */
    public void shutdown() {
        Threads.shutdownAndAwaitTermination(EXECUTOR);
    }


}
