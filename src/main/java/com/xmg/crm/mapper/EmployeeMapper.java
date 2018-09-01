package com.xmg.crm.mapper;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.query.QueryObject;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

	Long queryByConditionCount(QueryObject qo);

	List<Employee> queryByCondition(QueryObject qo);
}