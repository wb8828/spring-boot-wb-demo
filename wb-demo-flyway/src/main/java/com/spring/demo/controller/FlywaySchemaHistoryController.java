package com.spring.demo.controller;

import com.spring.demo.AjaxResult;
import com.spring.demo.domain.FlywaySchemaHistory;
import com.spring.demo.pojo.BasePageModel;
import com.spring.demo.pojo.TableDataInfo;
import com.spring.demo.service.IFlywaySchemaHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/flyway")
public class FlywaySchemaHistoryController extends BasePageModel {
    private final IFlywaySchemaHistoryService flywaySchemaHistoryService;


    /**
     * 查询工器具台账列表
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody FlywaySchemaHistory flywaySchemaHistory) {
        startPage(flywaySchemaHistory.getPageNum(),flywaySchemaHistory.getPageSize());
        List<FlywaySchemaHistory> list = flywaySchemaHistoryService.selectFlywaySchemaHistoryList(flywaySchemaHistory);

        return getDataTable(list);
    }


    /**
     * 获取工器具台账详细信息
     */
    @GetMapping(value = "/{installedRank}")
    public AjaxResult getInfo(@PathVariable("installedRank") Long installedRank) {
        return AjaxResult.success(flywaySchemaHistoryService.selectFlywaySchemaHistoryByInstalledRank(installedRank));

    }

    /**
     * 新增工器具台账
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody FlywaySchemaHistory flywaySchemaHistory) {
        return AjaxResult.success(flywaySchemaHistoryService.insertFlywaySchemaHistory(flywaySchemaHistory));
    }

    /**
     * 修改工器具台账
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody FlywaySchemaHistory flywaySchemaHistory) {
        return AjaxResult.success(flywaySchemaHistoryService.updateFlywaySchemaHistory(flywaySchemaHistory));
    }

    /**
     * 删除工器具台账
     */
    @GetMapping("/remove")
    public AjaxResult remove(@RequestBody Long[] installedRanks) {
        return AjaxResult.success(flywaySchemaHistoryService.deleteFlywaySchemaHistoryByInstalledRanks(installedRanks));
    }
}
