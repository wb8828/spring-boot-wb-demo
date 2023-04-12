package com.spring.demo.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author: wb
 * @description: 测试Swagger接口
 * @date: 2023-04-12 16:00
 */
@Api(tags = {"测试"})
@RestController
public class TestController {

    @ApiOperation("测试接口一")
    @PostMapping("/test1")
    public TestVO test1(@ApiParam(value = "接收参数",example = "{\"string\": \"参数示例\"}") @RequestBody TestDTO testDTO) {
        TestVO testVO = new TestVO();
        testVO.setString("str");
        return testVO;
    }


    @ApiOperation("测试接口二")
    @ApiIgnore // 隐藏此接口
    @GetMapping("/test2")
    public Object test2() {
        return null;
    }
}