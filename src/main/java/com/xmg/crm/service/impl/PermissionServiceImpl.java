package com.xmg.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.crm.domain.Permission;
import com.xmg.crm.mapper.PermissionMapper;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.PermissionQueryObject;
import com.xmg.crm.query.QueryObject;
import com.xmg.crm.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private PermissionMapper dao;
	
	public PageResult queryByCondition(QueryObject qo) {
		Long count = dao.queryByConditionCount(qo);
		if (count>0) {
			List<Permission> list = dao.queryByCondition(qo);
			return  new PageResult(count, list);
		}else {
			return PageResult.EMPTY;
		}
	}

	public PageResult queryByRid(Long rid) {
		List<Permission> result = dao.queryByRid(rid);
		return  new PageResult(Long.parseLong(result.size()+""), result);
	}

}
