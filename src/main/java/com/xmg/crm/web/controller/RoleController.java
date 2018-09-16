package com.xmg.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.crm.domain.Role;
import com.xmg.crm.page.AjaxResult;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.EmployeeQueryObject;
import com.xmg.crm.service.IRoleService;

@Controller
public class RoleController {

	@Autowired
	private IRoleService service;
	
	@RequestMapping("/role")
	public String index(){
		return "role";
	}
	
	@RequestMapping("/role_list")
	@ResponseBody
	public PageResult list(EmployeeQueryObject qo){
		PageResult result = null;
		result = service.SelectByCondition(qo);
		return result;
	}
	
	@RequestMapping("/role_save")
	@ResponseBody
	public AjaxResult save(Role role){
		AjaxResult result = null;
		try {
			
			int effectCount = service.save(role);
			if (effectCount>0) {
				result = new AjaxResult(true, "保存成功");
			} else {
				result = new AjaxResult("保存失败");
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("保存异常,请联系管理员");
		}
		return result;
	}
	
	
	@RequestMapping("/role_update")
	@ResponseBody
	public AjaxResult update(Role role){
		AjaxResult result = null;
		try {
			int effectCount = service.update(role);
			if (effectCount>0) {
				result = new AjaxResult(true, "更新成功");
			}else{
				result = new AjaxResult("更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("更新异常,请联系管理员");
		}
		return result;
	}
}
