package com.spring.demo.generator.service;

import java.util.List;
import java.util.Map;

public interface IGeneratorService {

    List<Map<String,String>> getRandomMes(Integer num);

    String getRandomDate(String beginTime,String endTime);

    Map<String,String> getRandomTimeInterval(String beginTime,String endTime);
}
