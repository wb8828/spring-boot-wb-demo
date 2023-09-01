package com.spring.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.spring.demo.ResponseResult;
import com.spring.demo.domain.SysJobLog;
import com.spring.demo.service.ISysJobLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 调度日志操作处理
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/monitor/jobLog")
public class SysJobLogController {
    private final ISysJobLogService jobLogService;

    /**
     * 查询定时任务调度日志列表
     */
    @PostMapping("/list")
    public ResponseResult list(@RequestBody SysJobLog sysJobLog) {
        IPage<SysJobLog> list = jobLogService.selectJobLogListByPage(sysJobLog);
        return ResponseResult.successResult(list);
    }

    /**
     * 根据调度编号获取详细信息
     */
    @GetMapping(value = "/{jobLogId}")
    public ResponseResult getInfo(@PathVariable Long jobLogId) {
        return ResponseResult.successResult(jobLogService.selectJobLogById(jobLogId));
    }


    /**
     * 删除定时任务调度日志
     */
    @GetMapping("/del/{jobLogIds}")
    public ResponseResult remove(@PathVariable Long[] jobLogIds) {
        return ResponseResult.successResult(jobLogService.deleteJobLogByIds(jobLogIds));
    }

    /**
     * 清空定时任务调度日志
     */
    @GetMapping("/clean")
    public ResponseResult clean() {
        jobLogService.cleanJobLog();
        return ResponseResult.successResult();
    }

}
