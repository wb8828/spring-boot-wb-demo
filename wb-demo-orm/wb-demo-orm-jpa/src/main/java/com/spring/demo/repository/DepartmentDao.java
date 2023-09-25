package com.spring.demo.repository;

import com.spring.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * User Dao
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
    /**
     * 根据层级查询部门
     *
     * @param level 层级
     * @return 部门列表
     */
    List<Department> findDepartmentsByLevels(Integer level);

    /**
     * 根据排序查询部门
     *
     * @param orderNo 层级
     * @return 部门列表
     */
    List<Department> findDepartmentsByOrderNo(Integer orderNo);
}
