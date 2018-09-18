package com.xmg.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.crm.domain.Permission;
import com.xmg.crm.domain.Role;
import com.xmg.crm.mapper.RoleMapper;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;
import com.xmg.crm.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper dao;
	
	public int save(Role role) {
		int effectCount = dao.insert(role);
		//处理中间表关系
		List<Permission> permissions = role.getPermissions();
		if (permissions!=null) {
			for (Permission permission : permissions) {
				dao.handlerRelation(role.getId(), permission.getId());
			}
		}
		
		return effectCount;
	}

	public int update(Role role) {
		int effectCount = dao.updateByPrimaryKey(role);
		//处理中间表关系
		//先删除
		dao.deletePermissionByRid(role.getId());
		//后新增

		List<Permission> permissions = role.getPermissions();
		if (permissions!=null) {
			for (Permission permission : permissions) {
				dao.handlerRelation(role.getId(), permission.getId());
			}
		}
		
		
		return effectCount;
	}

	public int delete(Long id) {
		return dao.deleteByPrimaryKey(id);
	}

	public Role get(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Role> selectAll() {
		return dao.selectAll();
	}

	public PageResult SelectByCondition(QueryObject qo) {
		Long count = dao.queryByConditionCount(qo);
		if (count>0) {
			List<Role> result = dao.queryByCondition(qo);
			return  new PageResult(count, result);

		} else {
			return PageResult.EMPTY;
		}
	}

	public List<Long> queryRoleIdByEId(Long eid) {
		System.out.println("guowenkui=="+dao.queryRoleIdByEId(eid));
		return dao.queryRoleIdByEId(eid);
	}
}
