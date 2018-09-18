package com.xmg.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.domain.Role;
import com.xmg.crm.mapper.EmployeeMapper;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;
import com.xmg.crm.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeMapper dao;
	
	public int save(Employee emp) {
		int effectCount = dao.insert(emp);
		List<Role> roles = emp.getRoles();
		if (roles!=null) {
			for (Role role : roles) {
				dao.handlerRelation(emp.getId(), role.getId());
			}
		}
		return effectCount;
	}

	public int update(Employee emp) {
		int effectCount = dao.updateByPrimaryKey(emp);
		dao.deleteRelationByEid(emp.getId());
		List<Role> roles = emp.getRoles();
		if (roles!=null) {
			for (Role role : roles) {
				dao.handlerRelation(emp.getId(), role.getId());
			}
		}
		return effectCount;
	}

	public int delete(Long id) {
		return dao.deleteByPrimaryKey(id);
	}

	public Employee get(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Employee> selectAll() {
		return dao.selectAll();
	}

	public PageResult SelectByCondition(QueryObject qo) {
		Long count = dao.queryByConditionCount(qo);
		if (count>0) {
			List<Employee> result = dao.queryByCondition(qo);
			return  new PageResult(count, result);

		} else {
			return PageResult.EMPTY;
		}
	}

	@Override
	public Employee queryByLogin(String username, String password) {
		
		return dao.queryByLogin(username,password);
	}

	@Override
	public int updateState(Long id) {
		return dao.updateState(id);
	}

}
