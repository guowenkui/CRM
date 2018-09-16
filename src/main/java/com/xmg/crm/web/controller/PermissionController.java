package com.xmg.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.PermissionQueryObject;
import com.xmg.crm.service.IPermissionService;

@Controller
public class PermissionController {

	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping("/permission_list")
	@ResponseBody
	public PageResult list (PermissionQueryObject qo){
		PageResult result = permissionService.queryByCondition(qo);
		return result;
	}
}
