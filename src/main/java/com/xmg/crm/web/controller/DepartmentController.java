package com.xmg.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.crm.service.IDepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private IDepartmentService departmentServic;

	@RequestMapping("/department_queryForEmp")
	@ResponseBody
	public List queryForEmp(){
		
		List result = null;
		result = departmentServic.selectAll();
		return result;
	}
	
}
