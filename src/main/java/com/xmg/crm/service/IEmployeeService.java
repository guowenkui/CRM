package com.xmg.crm.service;

import java.util.List;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;

public interface IEmployeeService {
	int save(Employee emp);
	int update(Employee emp);
	int delete(Long id);
	Employee get(Long id);
	List<Employee> selectAll();
	PageResult SelectByCondition(QueryObject qo );
}
