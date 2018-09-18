package com.xmg.crm.mapper;

import com.xmg.crm.domain.Role;
import com.xmg.crm.query.QueryObject;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

	Long queryByConditionCount(QueryObject qo);

	List<Role> queryByCondition(QueryObject qo);
	
	int handlerRelation(@Param("rid")Long rid,@Param("pid")Long pid);
	
	int deletePermissionByRid(Long rid);

	List<Long> queryRoleIdByEId(Long eid);

}