package com.spring.demo.demo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 脱敏测试实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hyposensitization implements Serializable {

    private String name;

    @JsonSerialize(using = HyposensitizationSerializable.class)
    private String phone;
}