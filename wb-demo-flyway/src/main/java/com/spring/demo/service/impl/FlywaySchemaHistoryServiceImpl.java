package com.spring.demo.service.impl;

import com.spring.demo.domain.FlywaySchemaHistory;
import com.spring.demo.mapper.FlywaySchemaHistoryMapper;
import com.spring.demo.service.IFlywaySchemaHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 工器具台账Service业务层处理
 *
 * @author wb
 * @date 2023-09-05
 */
@Service
public class FlywaySchemaHistoryServiceImpl implements IFlywaySchemaHistoryService {
    @Autowired
    private FlywaySchemaHistoryMapper flywaySchemaHistoryMapper;

    /**
     * 查询工器具台账
     *
     * @param installedRank 工器具台账主键
     * @return 工器具台账
     */
    @Override
    public FlywaySchemaHistory selectFlywaySchemaHistoryByInstalledRank(Long installedRank) {
        return flywaySchemaHistoryMapper.selectFlywaySchemaHistoryByInstalledRank(installedRank);
    }

    /**
     * 查询工器具台账列表
     *
     * @param flywaySchemaHistory 工器具台账
     * @return 工器具台账
     */
    @Override
    public List<FlywaySchemaHistory> selectFlywaySchemaHistoryList(FlywaySchemaHistory flywaySchemaHistory) {
        return flywaySchemaHistoryMapper.selectFlywaySchemaHistoryList(flywaySchemaHistory);
    }

    /**
     * 新增工器具台账
     *
     * @param flywaySchemaHistory 工器具台账
     * @return 结果
     */
    @Override
    public int insertFlywaySchemaHistory(FlywaySchemaHistory flywaySchemaHistory) {
        return flywaySchemaHistoryMapper.insertFlywaySchemaHistory(flywaySchemaHistory);
    }

    /**
     * 修改工器具台账
     *
     * @param flywaySchemaHistory 工器具台账
     * @return 结果
     */
    @Override
    public int updateFlywaySchemaHistory(FlywaySchemaHistory flywaySchemaHistory) {
        return flywaySchemaHistoryMapper.updateFlywaySchemaHistory(flywaySchemaHistory);
    }

    /**
     * 批量删除工器具台账
     *
     * @param installedRanks 需要删除的工器具台账主键
     * @return 结果
     */
    @Override
    public int deleteFlywaySchemaHistoryByInstalledRanks(Long[] installedRanks) {
        return flywaySchemaHistoryMapper.deleteFlywaySchemaHistoryByInstalledRanks(installedRanks);
    }

    /**
     * 删除工器具台账信息
     *
     * @param installedRank 工器具台账主键
     * @return 结果
     */
    @Override
    public int deleteFlywaySchemaHistoryByInstalledRank(Long installedRank) {
        return flywaySchemaHistoryMapper.deleteFlywaySchemaHistoryByInstalledRank(installedRank);
    }

    /**
     * 新增修改工器具台账信息
     *
     * @param flywaySchemaHistory 工器具台账
     * @return 结果
     */
    @Transactional
    @Override
    public boolean saveOrUpdate(FlywaySchemaHistory flywaySchemaHistory) {
        if ("".equals(flywaySchemaHistory.getInstalledRank()) || flywaySchemaHistory.getInstalledRank() == null) {
            return insertFlywaySchemaHistory(flywaySchemaHistory) > 0;
        } else {
            return updateFlywaySchemaHistory(flywaySchemaHistory) > 0;
        }

    }
}
