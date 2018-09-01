package com.xmg.crm.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class EmployeeServiceImplTest {

	@Autowired
	IEmployeeService employeeService;
	
	@Test
	public void testSave() {
		Employee emp = new Employee();
		emp.setAdmin(true);
		emp.setEmail("23@qq.com") ;
		emp.setInputtime(new Date());
		emp.setPassword("1234");
		emp.setState(true);
		emp.setTel("1313241234");
		emp.setUsername("admin");
		emp.setRealname("超级管理员");
		employeeService.save(emp);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByCondition() {
		fail("Not yet implemented");
	}

}
