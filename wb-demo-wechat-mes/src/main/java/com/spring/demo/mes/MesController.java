package com.spring.demo.mes;


import cn.hutool.core.util.StrUtil;
import com.spring.demo.prop.YYProp;
import com.spring.demo.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MesController {

    private final YYProp yyProp;

    @GetMapping(value = "/getMes")
    public Map<String, Object> getMes() {
        Map<String, Object> result = new HashMap<>();

        // 获取人员信息
        List<String> personList = FileUtils.getTxtContentList(FileUtils.getFile(yyProp.getPersonPath()));
        result.put("personList", personList);
        // 获取发送的内容
        String mes = FileUtils.getTxtContent(FileUtils.getFile(yyProp.getSendMes()));
        result.put("mes", mes);
//        result.put("mes", mes.replaceAll("\\n", "").replaceAll("\\r", ""));
        return result;
    }

    @PostMapping("/sendMes")
    public String sendMes() {
        // 获取人员信息
        List<String> personList = FileUtils.getTxtContentList(FileUtils.getFile(yyProp.getPersonPath()));
        // 获取发送的内容
        String content = FileUtils.getTxtContent(FileUtils.getFile(yyProp.getSendMes()));
        for (String person : personList) {
            if (StringUtils.isBlank(StringUtils.trim(person))){
                continue;
            }
            WechatMes.searchPerson(person, content);
            WechatMes.closeWechat();
        }
        return "发送成功";
    }


}