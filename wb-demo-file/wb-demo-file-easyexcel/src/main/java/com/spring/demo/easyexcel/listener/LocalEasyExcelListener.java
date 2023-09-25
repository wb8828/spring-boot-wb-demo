package com.spring.demo.easyexcel.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson2.JSON;
import com.spring.demo.easyexcel.test.vo.TestData;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
public class LocalEasyExcelListener extends AnalysisEventListener<TestData> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    List<TestData> list = new ArrayList<>();

    List<TestData> successList = new ArrayList<>();

    List<TestData> errorList = new ArrayList<>();


    public LocalEasyExcelListener(List<TestData> errorList, List<TestData> successList) {
        this.errorList = errorList;
        this.successList = successList;
    }

    @Override
    public void invoke(TestData data, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            checkData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        checkData();
        log.info("所有数据解析完成！");
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    //假装这个是验证数据
    private void checkData() {
        final boolean[] isCheck = {true};

        list.stream().forEach(e -> {
            if (isCheck[0]) {
                errorList.add(e);
            } else {
                successList.add(e);
            }
            isCheck[0] = isCheck[0] == false;
        });

    }
}
