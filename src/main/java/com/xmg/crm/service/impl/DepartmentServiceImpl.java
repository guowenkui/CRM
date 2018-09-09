package com.xmg.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.crm.domain.Department;
import com.xmg.crm.mapper.DepartmentMapper;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;
import com.xmg.crm.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentMapper dao;
	public int save(Department dept) {
		return dao.insert(dept);
	}

	public int update(Department dept) {
		return dao.updateByPrimaryKey(dept);
	}

	public int delete(Long id) {
		return dao.deleteByPrimaryKey(id);
	}

	public Department get(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Department> selectAll() {
		return dao.selectAll();
	}

	public PageResult SelectByCondition(QueryObject qo) {
		return null;
	}

}
