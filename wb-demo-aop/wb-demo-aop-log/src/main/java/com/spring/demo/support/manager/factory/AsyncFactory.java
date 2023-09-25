package com.spring.demo.support.manager.factory;

import cn.hutool.extra.spring.SpringUtil;
import com.spring.demo.log.domain.SysOperLog;
import com.spring.demo.log.service.ISysOperLogService;
import com.spring.demo.support.utils.AddressUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 */
@Slf4j
public class AsyncFactory {


    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOperLog(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtil.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }
}
