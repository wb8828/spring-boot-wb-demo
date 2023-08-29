package com.spring.demo.system.setting.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GlobalSetting {

    /**
     * 获取开启验证码登录
     */
    private Boolean captchaEnabled;
}