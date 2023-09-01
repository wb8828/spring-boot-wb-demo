package com.spring.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.spring.demo.ResponseResult;
import com.spring.demo.constant.Constants;
import com.spring.demo.domain.SysJob;
import com.spring.demo.service.ISysJobService;
import com.spring.demo.utils.CronUtils;
import com.spring.demo.utils.ScheduleUtils;
import com.spring.demo.utils.TaskException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

/**
 * 调度任务信息操作处理
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/monitor/job")
public class SysJobController {
    private final ISysJobService jobService;

    /**
     * 查询定时任务列表
     */
    @PostMapping("/list")
    public ResponseResult list(@RequestBody SysJob sysJob) {

        IPage<SysJob> list = jobService.selectJobListByPage(sysJob);
        return ResponseResult.successResult(list);
    }

    /**
     * 获取定时任务详细信息
     */
    @GetMapping(value = "/{jobId}")
    public ResponseResult getInfo(@PathVariable("jobId") Long jobId) {
        return ResponseResult.successResult(jobService.selectJobById(jobId));
    }

    /**
     * 新增定时任务
     */
    @PostMapping("/addJob")
    public ResponseResult add(@RequestBody SysJob job) throws SchedulerException, TaskException {
        if (!CronUtils.isValid(job.getCronExpression())) {
            return ResponseResult.failedResult("新增任务'" + job.getJobName() + "'失败，Cron表达式不正确");
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return ResponseResult.failedResult("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'rmi'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[]{Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS})) {
            return ResponseResult.failedResult("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'ldap(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[]{Constants.HTTP, Constants.HTTPS})) {
            return ResponseResult.failedResult("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'http(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), Constants.JOB_ERROR_STR)) {
            return ResponseResult.failedResult("新增任务'" + job.getJobName() + "'失败，目标字符串存在违规");
        } else if (!ScheduleUtils.whiteList(job.getInvokeTarget())) {
            return ResponseResult.failedResult("新增任务'" + job.getJobName() + "'失败，目标字符串不在白名单内");
        }
//        job.setCreateBy(getUsername());
        job.setCreateBy("管理员");
        return ResponseResult.successResult(jobService.insertJob(job));
    }

    /**
     * 修改定时任务
     */
    @PostMapping("/updateJob")
    public ResponseResult edit(@RequestBody SysJob job) throws SchedulerException, TaskException {
        if (!CronUtils.isValid(job.getCronExpression())) {
            return ResponseResult.failedResult("修改任务'" + job.getJobName() + "'失败，Cron表达式不正确");
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return ResponseResult.failedResult("修改任务'" + job.getJobName() + "'失败，目标字符串不允许'rmi'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[]{Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS})) {
            return ResponseResult.failedResult("修改任务'" + job.getJobName() + "'失败，目标字符串不允许'ldap(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[]{Constants.HTTP, Constants.HTTPS})) {
            return ResponseResult.failedResult("修改任务'" + job.getJobName() + "'失败，目标字符串不允许'http(s)'调用");
        } else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), Constants.JOB_ERROR_STR)) {
            return ResponseResult.failedResult("修改任务'" + job.getJobName() + "'失败，目标字符串存在违规");
        } else if (!ScheduleUtils.whiteList(job.getInvokeTarget())) {
            return ResponseResult.failedResult("修改任务'" + job.getJobName() + "'失败，目标字符串不在白名单内");
        }
//        job.setUpdateBy(getUsername());
        job.setUpdateBy("管理员");
        return ResponseResult.successResult(jobService.updateJob(job));
    }

    /**
     * 定时任务状态修改
     */
    @PostMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody SysJob job) throws SchedulerException {
        SysJob newJob = jobService.selectJobById(job.getJobId());
        newJob.setStatus(job.getStatus());
        return ResponseResult.successResult(jobService.changeStatus(newJob));
    }

    /**
     * 定时任务立即执行一次
     */
    @PostMapping("/run")
    public ResponseResult run(@RequestBody SysJob job) throws SchedulerException {
        boolean result = jobService.run(job);
        return result ? ResponseResult.successResult() : ResponseResult.failedResult("任务不存在或已过期！");
    }

    /**
     * 删除定时任务
     */
    @GetMapping("/remove/{jobIds}")
    public ResponseResult remove(@PathVariable Long[] jobIds) throws SchedulerException, TaskException {
        jobService.deleteJobByIds(jobIds);
        return ResponseResult.successResult();
    }
}
