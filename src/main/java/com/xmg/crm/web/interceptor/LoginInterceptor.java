package com.xmg.crm.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import com.xmg.crm.domain.Employee;
import com.xmg.crm.domain.Permission;
import com.xmg.crm.util.PermissionUtils;
import com.xmg.crm.util.UserContext;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserContext.set(request);
		Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
		if (user ==null) {
			response.sendRedirect("/login.jsp");
			return false;
		}
		//URL权限控制
		//1.将请求变为权限表达式
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Object bean =  handlerMethod.getBean();
	    Method method = handlerMethod.getMethod();
		
	    String function = bean.getClass().getName()+":"+method.getName();
	    //如果返回结果为true,表示用户拥有这样的权限或者该请求不受权限控制
	    //如果返回false,拦截请求
	    if (PermissionUtils.checkPermission(function)) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
