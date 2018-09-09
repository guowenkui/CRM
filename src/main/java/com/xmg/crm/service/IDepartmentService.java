package com.xmg.crm.service;

import java.util.List;

import com.xmg.crm.domain.Department;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;

public interface IDepartmentService {
	int save(Department dept);
	int update(Department dept);
	int delete(Long id);
	Department get(Long id);
	List<Department> selectAll();
	PageResult SelectByCondition(QueryObject qo );
}
