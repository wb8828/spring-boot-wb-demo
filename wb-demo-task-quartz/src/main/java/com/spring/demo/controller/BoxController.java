//package com.spring.demo.controller;
//
//import com.jxd.base.entity.ResponseResult;
//import com.jxd.quartz.constant.BoxConstants;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 定时器下拉框
// */
//@RestController
//@RequestMapping("/monitor/box")
//public class BoxController {
//
//    /**
//     * 查询执行状态码表
//     */
//    @GetMapping("/sys_common_status")
//    public ResponseResult sys_common_status() {
//
//        return ResponseResult.successResult(BoxConstants.sys_common_status);
//    }
//
//    /**
//     * 查询任务分组码表
//     */
//    @GetMapping("/sys_job_group")
//    public ResponseResult sys_job_group() {
//        return ResponseResult.successResult(BoxConstants.sys_job_group);
//    }
//
//    /**
//     * 查询任务状态码表
//     */
//    @GetMapping("/sys_job_status")
//    public ResponseResult sys_job_status() {
//        return ResponseResult.successResult(BoxConstants.sys_job_status);
//    }
//}