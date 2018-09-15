package com.xmg.crm.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.page.AjaxResult;
import com.xmg.crm.page.PageResult;
import com.xmg.crm.query.EmployeeQueryObject;
import com.xmg.crm.service.IEmployeeService;
import com.xmg.crm.util.UserContext;

import lombok.val;

@Controller
public class EmployeeController {

	
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping("/employee")
	public String index(){
		System.out.println("IndexController.employeeList");
		return "employee";
	}
	
	@ModelAttribute
	public void before(Long id,Model model){
		
		if (id!=null) {
			//更新操作
			Employee emp = new Employee();
			emp.setPassword("8888");
			model.addAttribute(emp);
		}
	}
	
	
	@RequestMapping("/employee_delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		AjaxResult result = null;
		try {
			int effectCount =  employeeService.updateState(id);
			if (effectCount>0) {
				result = new AjaxResult(true, "离职成功");
			}else {
				result = new AjaxResult("离职失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("离职异常,请联系管理员");
		}
		return result;
	}
	
	
	
	@RequestMapping("/employee_save")
	@ResponseBody
	public AjaxResult save(Employee emp){
		AjaxResult result = null;
		try {
			emp.setAdmin(false);
			emp.setInputtime(new Date());
			emp.setState(true);
			emp.setPassword("6666");
			int effectCount = employeeService.save(emp);
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
	
	
	@RequestMapping("/employee_update")
	@ResponseBody
	public AjaxResult update(Employee emp){
		AjaxResult result = null;
		try {
			int effectCount = employeeService.update(emp);
			if (effectCount>0) {
				result = new AjaxResult(true, "更新成功");
			} else {
				result = new AjaxResult("更新失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result = new AjaxResult("更新异常,请联系管理员");
		}
		return result;
	}
	
	@RequestMapping("/employee_list")
	@ResponseBody
	public PageResult list(EmployeeQueryObject qo){
		PageResult result = null;
		result = employeeService.SelectByCondition(qo);
		return result;
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxResult login(String username,String password,HttpServletRequest request){
		UserContext.set(request);
		AjaxResult result = null;
		
		Employee user = employeeService.queryByLogin(username,password);
		if (user !=null) {
			request.getSession().setAttribute(UserContext.USER_IN_SESSION, user);
			
			result = new AjaxResult(true, "登录成功");
		} else {
			result = new AjaxResult("账号密码有误");
		}
		return result;
	}
	
	
}
