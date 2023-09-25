package com.spring.demo.easyexcel.test.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.spring.demo.easyexcel.converter.LocalStrConverter;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ExcelIgnoreUnannotated
public class TestData {

    @ExcelProperty(value = "序号", order = 0)
    private Integer serialNumber;

    @ExcelProperty(value = "名称", order = 1)
    private String name;

    @ExcelProperty(value = "性别", order = 2)
    private String sex;

    @NumberFormat("#.##%")
    @ExcelProperty(value = "身高", order = 3)
    private Double height;

    @ExcelProperty(value = "成绩排名", order = 4,converter = LocalStrConverter.class)
    private String ranking;

    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty(value = "生日", order = 5)
    private Date birthday;

    @ExcelProperty(value = "入学时间", order = 6)
    private Date enrollmentTime;

    public TestData(){

    }

    public TestData(String name, String sex, double height, String ranking, Date birthday, Date enrollmentTime) {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.ranking = ranking;
        this.birthday = birthday;
        this.enrollmentTime = enrollmentTime;
    }

    public static List<TestData> data() {
        return new ArrayList<TestData>(){{
            add(new TestData("张三","0",170.5,"5",new Date(),new Date()));
            add(new TestData("李四","0",180.9,"1",new Date(),new Date()));
            add(new TestData("王燕","1",165.1,"2",new Date(),new Date()));
            add(new TestData("赵七","1",165.1,"10",new Date(),new Date()));
            add(new TestData("钱八","1",165.1,"11",new Date(),new Date()));
        }};
    }
}