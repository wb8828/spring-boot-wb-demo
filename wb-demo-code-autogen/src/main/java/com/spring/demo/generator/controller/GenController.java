package com.spring.demo.generator.controller;


import cn.hutool.core.convert.Convert;
import com.spring.demo.AjaxResult;
import com.spring.demo.generator.domain.CreateCodeGenConfig;
import com.spring.demo.generator.domain.GenGlobalConfig;
import com.spring.demo.generator.domain.GenTable;
import com.spring.demo.generator.domain.GenTableColumn;
import com.spring.demo.generator.mapper.GenTableMapper;
import com.spring.demo.generator.service.IGenTableColumnService;
import com.spring.demo.generator.service.IGenTableService;
import com.spring.demo.log.annotation.Log;
import com.spring.demo.log.enums.BusinessType;
import com.spring.demo.pojo.BasePageModel;
import com.spring.demo.pojo.TableDataInfo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成 操作处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/tool/gen")
public class GenController extends BasePageModel {
    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    @Resource
    private GenTableMapper genTableMapper;

    /**
     * 查询代码生成列表
     */
    @Log(title = "操作日志", businessType = BusinessType.QUERY)
    @GetMapping("/list")
    public TableDataInfo genList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectGenTableList(genTable);
        return getDataTable(list);
    }

    /**
     * 修改代码生成业务
     */
    @GetMapping(value = "/{tableId}")
    public AjaxResult getInfo(@PathVariable Long tableId) {
        GenTable table = genTableService.selectGenTableById(tableId);
        List<GenTable> tables = genTableService.selectGenTableAll();
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", table);
        map.put("rows", list);
        map.put("tables", tables);
        return AjaxResult.success(map);
    }

    /**
     * 查询数据库列表
     */
    @GetMapping("/db/list")
    public TableDataInfo dataList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectDbTableList(genTable);
        return getDataTable(list);
    }

    /**
     * 查询数据表字段列表
     */
    @GetMapping(value = "/column/{tableId}")
    public TableDataInfo columnList(Long tableId) {
        TableDataInfo dataInfo = new TableDataInfo();
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return dataInfo;
    }

    /**
     * 导入表结构（保存）
     */
    @PostMapping("/importTable")
    public AjaxResult importTableSave(String tables) {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        genTableService.importGenTable(tableList);
        return AjaxResult.success();
    }

    @GetMapping("/genConfig")
    public AjaxResult genConfig() {
        return AjaxResult.success(genTableService.genConfig());
    }

    @GetMapping("/globalConfig")
    public AjaxResult globalConfig() {
        return AjaxResult.success(genTableService.selectGenGlobalConfigById("1"));
    }

    @PostMapping("/saveOrUpdateGlobalConfig")
    public AjaxResult saveOrUpdateGlobalConfig(@RequestBody GenGlobalConfig config) {
        if (StringUtils.isNotBlank(config.getId())) {
            genTableService.updateGenGlobalConfig(config);
        } else {
            config.setId("1");
            genTableService.insertGenGlobalConfig(config);
        }
        return AjaxResult.success();
    }

    @PostMapping("/saveOrUpdateConfig")
    public AjaxResult saveOrUpdateConfig(@RequestBody CreateCodeGenConfig createCodeGenConfig) {
        return AjaxResult.success(genTableService.saveOrUpdateConfig(createCodeGenConfig));
    }

    /**
     * 修改保存代码生成业务
     */
    @PutMapping
    public AjaxResult editSave(@Validated @RequestBody GenTable genTable) {
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return AjaxResult.success();
    }

    /**
     * 删除代码生成
     */
    @DeleteMapping("/{tableIds}")
    public AjaxResult remove(@PathVariable Long[] tableIds) {
        genTableService.deleteGenTableByIds(tableIds);
        return AjaxResult.success();
    }

    /**
     * 预览代码
     */
    @GetMapping("/preview/{tableId}")
    public AjaxResult preview(@PathVariable("tableId") Long tableId) throws IOException {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return AjaxResult.success(dataMap);
    }

    /**
     * 生成代码（下载方式）
     */
    @GetMapping("/download/{tableName}")
    public void download(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = genTableService.downloadCode(tableName);
        genCode(response, data);
    }

    /**
     * 接口直接调用的形式
     *
     * @param response
     * @param tableNames
     * @param author
     * @param packageName
     * @param moduleName
     * @param functionName
     * @throws IOException
     */
    @GetMapping("/creatCode")
    public void creatCode(HttpServletResponse response,
                          @RequestParam(value = "tableNames") String tableNames,
                          @RequestParam(value = "author", required = false) String author,
                          @RequestParam(value = "packageName", required = false) String packageName,
                          @RequestParam(value = "moduleName", required = false) String moduleName,
                          @RequestParam(value = "functionName", required = false) String functionName
    ) throws IOException {
        String[] tableNameList = Convert.toStrArray(tableNames);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNameList);
        // 先删后增
        genTableService.deleteGenTableByTableNames(tableNameList);
        genTableService.importGenTableCustom(tableList, packageName, moduleName, author);
        byte[] data = genTableService.downloadCode(tableNameList);
        genCode(response, data);
    }


    /**
     * 生成代码（自定义路径）
     */
    @GetMapping("/genCode/{tableName}")
    public AjaxResult genCode(@PathVariable("tableName") String tableName) {
        genTableService.generatorCode(tableName);
        return AjaxResult.success();
    }

    /**
     * 同步数据库
     */
    @GetMapping("/synchDb/{tableName}")
    public AjaxResult synchDb(@PathVariable("tableName") String tableName) {
        genTableService.synchDb(tableName);
        return AjaxResult.success();
    }

    /**
     * 批量生成代码
     */
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.downloadCode(tableNames);
        genCode(response, data);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    @GetMapping("/getTreeData")
    public AjaxResult getTreeData() {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("type", "1");
        List<String> tableNames = genTableMapper.getTableNames();

        List<Map<String, String>> result = new ArrayList<>();
        tableNames.stream().forEach(e -> {
            Map<String, String> map = new HashMap<>();
            map.put("table_name", e);
            result.add(map);

        });
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @GetMapping("/getFieldNames")
    public AjaxResult getFieldNames(@RequestParam(value = "tname") String tname) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("type", "1");
        List<String> fieldNames = genTableMapper.getFieldNames(tname);

        List<Map<String, String>> result = new ArrayList<>();
        fieldNames.stream().forEach(e -> {
            Map<String, String> map = new HashMap<>();
            map.put("COLUMN_NAME", e);
            result.add(map);

        });
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @PostMapping("/sendSQL")
    public AjaxResult ext() {
        return AjaxResult.success();
    }
}