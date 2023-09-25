package com.spring.demo.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: 自己的名字
 * @description:
 * @date: 2023-08-08 09:56
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Holiday {
    private boolean holiday;

    private String name;

    private int wage;
    private String date;

    private String rest;

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }
}