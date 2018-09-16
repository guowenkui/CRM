package com.xmg.crm.service;

import java.util.List;

import com.xmg.crm.domain.Role;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;

public interface IRoleService {
	int save(Role role);
	int update(Role role);
	Role get(Long id);
	List<Role> selectAll();
	PageResult SelectByCondition(QueryObject qo );
	
	int deletePermissionByRid(Long rid);
}
