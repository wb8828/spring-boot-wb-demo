package com.spring.demo.generator.service.impl;

import cn.binarywang.tools.generator.*;
import cn.binarywang.tools.generator.bank.BankCardNumberGenerator;
import cn.binarywang.tools.generator.base.GenericGenerator;
import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Maps;
import com.spring.demo.generator.service.IGeneratorService;
import com.spring.demo.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 生成随机信息
 */
@Service
public class GeneratorServiceImpl implements IGeneratorService {

    @Override
    public List<Map<String, String>> getRandomMes(Integer num) {
        ChineseNameGenerator nameGenerator = ChineseNameGenerator.getInstance();
        ChineseMobileNumberGenerator mobileNumberGenerator = ChineseMobileNumberGenerator.getInstance();
        GenericGenerator idCardGenerator = ChineseIDCardNumberGenerator.getInstance();
        GenericGenerator addressGenerator = ChineseAddressGenerator.getInstance();
        List<Map<String, String>> list = new ArrayList<>(num);
        GenericGenerator bankCardNumberGenerator = BankCardNumberGenerator.getInstance();
        EnglishNameGenerator englishNameGenerator = EnglishNameGenerator.getInstance();
        GenericGenerator emailAddressGenerator = EmailAddressGenerator.getInstance();
        IntStream.range(0, num).forEach(e -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("chineseName", nameGenerator.generate());
            map.put("mobile", mobileNumberGenerator.generate());
            map.put("idCard", idCardGenerator.generate());
            map.put("address", addressGenerator.generate());
            map.put("bankCard", bankCardNumberGenerator.generate());
            map.put("englishName", englishNameGenerator.generate());
            map.put("email", emailAddressGenerator.generate());
            list.add(map);
        });
        return list;
    }

    @Override
    public String getRandomDate(String beginTime, String endTime) {
        return DateUtils.randomDate(beginTime, endTime);
    }

    @Override
    public Map<String, String> getRandomTimeInterval(String beginTime, String endTime) {
        Map<String, String> resultMap = Maps.newHashMap();
        LocalDate beginLocalDate = LocalDate.parse(getRandomDate(beginTime, endTime));
        int randomYear = RandomUtil.randomInt(1, 10);
        LocalDate endLocalDate = beginLocalDate.plusYears(randomYear);
        resultMap.put("beginTime", beginLocalDate.toString());
        resultMap.put("endTime", endLocalDate.plusDays(1).toString());
        resultMap.put("interval", String.valueOf(randomYear));
        return resultMap;
    }

}