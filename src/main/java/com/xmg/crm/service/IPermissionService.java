package com.xmg.crm.service;

import java.util.List;

import com.xmg.crm.domain.Permission;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;

public interface IPermissionService {
	PageResult queryByCondition(QueryObject qo );

	PageResult queryByRid(Long rid);

	Permission queryByResource(String function);

	List<Permission> queryPermissionByEid(Long id);
}
