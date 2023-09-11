package com.spring.demo.mapper;

import com.spring.demo.domain.FlywaySchemaHistory;

import java.util.List;

public interface FlywaySchemaHistoryMapper
{
    /**
     * 查询工器具台账
     * 
     * @param installedRank 工器具台账主键
     * @return 工器具台账
     */
    public FlywaySchemaHistory selectFlywaySchemaHistoryByInstalledRank(Long installedRank);

    /**
     * 查询工器具台账列表
     * 
     * @param flywaySchemaHistory 工器具台账
     * @return 工器具台账集合
     */
    public List<FlywaySchemaHistory> selectFlywaySchemaHistoryList(FlywaySchemaHistory flywaySchemaHistory);

    /**
     * 新增工器具台账
     * 
     * @param flywaySchemaHistory 工器具台账
     * @return 结果
     */
    public int insertFlywaySchemaHistory(FlywaySchemaHistory flywaySchemaHistory);

    /**
     * 修改工器具台账
     * 
     * @param flywaySchemaHistory 工器具台账
     * @return 结果
     */
    public int updateFlywaySchemaHistory(FlywaySchemaHistory flywaySchemaHistory);

    /**
     * 删除工器具台账
     * 
     * @param installedRank 工器具台账主键
     * @return 结果
     */
    public int deleteFlywaySchemaHistoryByInstalledRank(Long installedRank);

    /**
     * 批量删除工器具台账
     * 
     * @param installedRanks 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlywaySchemaHistoryByInstalledRanks(Long[] installedRanks);
}
