package com.spring.demo.constant;


import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: wb
 * @description: 下拉框（静态代码）
 * @date: 2023-03-31 09:25
 */
public class BoxConstants {

    private static final String common_status = "0->成功,1->失败";
    public final static List<Box> sys_common_status = strToBox(common_status);
    private static final String job_group = "DEFAULT->默认,SYSTEM->系统";
    public final static List<Box> sys_job_group = strToBox(job_group);
    private static final String job_status = "0->开启,1->暂停";
    public final static List<Box> sys_job_status = strToBox(job_status);

    private static List<Box> strToBox(String str) {
        if (StrUtil.isBlank(str)) {
            return Lists.newArrayList();
        }
        List<Box> list = Lists.newArrayList();
        String[] split = str.split(",");
        for (String s : split) {
            String[] boxStr = s.split("->");
            list.add(new Box(boxStr[0].trim(), boxStr[1].trim()));
        }
        return list;
    }

    private static class Box {
        private String value;

        private String label;

        public Box() {

        }

        public Box(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}