package com.xmg.crm.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmg.crm.domain.Employee;
import com.xmg.crm.domain.SystemLog;
import com.xmg.crm.service.ISystemLogService;
import com.xmg.crm.service.impl.SystemLogServiceImpl;

public class LogUtil {
	
	@Autowired
	private ISystemLogService service;
	
	public void writeLog(JoinPoint joinPoint) throws Exception{
		
		//如果目标对象就是ISystemLogService,应该放行
		if (joinPoint.getTarget() instanceof ISystemLogService) {
			return;
		}
		SystemLog log = new SystemLog();
		log.setOptime(new Date());
		HttpServletRequest request = UserContext.get();
		Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
		log.setOpuser(user);
		Object target = joinPoint.getTarget();//目标对象
		Signature signature = joinPoint.getSignature();//方法签名
		String function = target.getClass().getName()+":"+signature.getName();//类全限定名+":"+方法名
		log.setFunction(function);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);//空的值就不要序列化了
		String params = mapper.writeValueAsString(joinPoint.getArgs());
		
		System.out.println("*******************"+user);
		
		log.setParams(params);
		
		service.save(log);
		
		System.out.println("日志编写.........");
	}
}
