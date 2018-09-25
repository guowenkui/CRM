package com.xmg.crm.util;

import javax.servlet.http.HttpServletRequest;

public class UserContext {
	
	public static final String USER_IN_SESSION = "userINsession";
	public static final String PERMISSION_IN_SESSION = "permissionINsession";

	public static ThreadLocal<HttpServletRequest> local = new ThreadLocal<HttpServletRequest>();
	
	public static void set(HttpServletRequest request){
		local.set(request);
	}
	
	public static HttpServletRequest get(){
		return local.get();
	}
}
