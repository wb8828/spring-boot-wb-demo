package com.spring.demo.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Params {

    private String params1;
    private String params2;
    private String params3;
    private String params4;
}