package com.spring.demo.home.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: wb
 * @description:
 * @date: 2023-03-02 17:16
 */
public class CountDataDTO {

    @JsonProperty(value = "code")
    private String iCode;

    public String geticode() {
        return iCode;
    }

    public void seticode(String iCode) {
        this.iCode = iCode;
    }
}