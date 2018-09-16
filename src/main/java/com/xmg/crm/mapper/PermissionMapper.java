package com.xmg.crm.mapper;

import com.xmg.crm.domain.Permission;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
    
    Long queryByConditionCount(QueryObject qo);
    
    List<Permission> queryByCondition(QueryObject qo);

	List<Permission> queryByRid(Long rid);
	
}