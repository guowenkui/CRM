package com.xmg.crm.mapper;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.query.QueryObject;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

	Long queryByConditionCount(QueryObject qo);

	List<Employee> queryByCondition(QueryObject qo);

	Employee queryByLogin(@Param("username")String username, @Param("password")String password);
}