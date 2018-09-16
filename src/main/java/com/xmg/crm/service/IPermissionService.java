package com.xmg.crm.service;

import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;

public interface IPermissionService {
	PageResult queryByCondition(QueryObject qo );

	PageResult queryByRid(Long rid);
}
