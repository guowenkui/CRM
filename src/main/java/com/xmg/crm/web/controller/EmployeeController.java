package com.xmg.crm.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.crm.domain.Employee;
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
	
	
	@RequestMapping("/employee_list")
	@ResponseBody
	public PageResult list(EmployeeQueryObject qo){
		PageResult result = null;
		result = employeeService.SelectByCondition(qo);
		return result;
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public Map login(String username,String password,HttpSession session){
		Map<String, Object> result = new HashMap<String,Object>();
		
		Employee user = employeeService.queryByLogin(username,password);
		if (user !=null) {
			session.setAttribute(UserContext.USER_IN_SESSION, user);
			result.put("success", true);
			result.put("msg", "登录成功");
		} else {
			result.put("success", false);
			result.put("msg", "账号密码有误");
		}
		return result;
	}
	
	
}
