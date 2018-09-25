package com.xmg.crm.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmg.crm.domain.Employee;
import com.xmg.crm.domain.Permission;
import com.xmg.crm.service.IPermissionService;

@Component
public class PermissionUtils {

	private static IPermissionService permissionService;
	public static boolean checkPermission(String function) {
		HttpSession session = UserContext.get().getSession();
		Employee user = (Employee) session.getAttribute(UserContext.USER_IN_SESSION);
		if (user.getAdmin()) {
			return true;
		}
		
		//需要查询权限表,看是否需要权限控制

		Permission p = permissionService.queryByResource(function);
		if (p!=null) {
			//该请求需要权限控制
			//先获取用户的权限
			List<Permission> userPermission =  (List<Permission>) UserContext.get().getSession().getAttribute(UserContext.PERMISSION_IN_SESSION);
			
			System.out.println("asdfasdf=="+function);
			//All权限匹配
			String allFunction = function.split(":")[0]+":all";
			System.out.println("allFunction=="+allFunction);
			for (Permission permission : userPermission) {
				System.out.println("permission.getResource()=="+permission.getResource());
				if (permission.getResource().equals(function)||permission.getResource().equals(allFunction)) {
					//能找到说明用户有这样的一个权限集合
					System.out.println("===============放行");
					return true;
				}
			}
			System.out.println("===============拦截");
			
			return false;
		} else {
			System.out.println("===============直接放行");
			//不需要权限控制,直接放行
			return true;
		}
	}
	
	@Autowired//不能写static,否则不能注入
	public void setPermissionService(IPermissionService permissionService) {
		PermissionUtils.permissionService = permissionService;
	}
	
	

}
