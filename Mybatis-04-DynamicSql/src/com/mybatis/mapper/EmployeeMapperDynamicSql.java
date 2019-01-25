package com.mybatis.mapper;

import com.mybatis.bean.Employee;

import java.util.List;

/**
 * 动态SQL
 */
public interface EmployeeMapperDynamicSql {

    /**
     * 测试
     * @return
     */
    List<Employee> getByConditionIf(Employee employee);

}
