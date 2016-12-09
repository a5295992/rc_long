package com.rc_long.utils;

import javax.servlet.http.HttpServletRequest;

import com.rc_long.Entity.ShiroUser;

/**
 * 获取当前用户信息
 * @author longge
 *
 */
public class CurrentSession {
	private  HttpServletRequest req;
	
	public CurrentSession(){
		
	}
	public CurrentSession(HttpServletRequest req){
		this.req=req;
	}
	public ShiroUser getShiroUser(){
		return (ShiroUser) req.getSession().getAttribute("ShiroUser");
	}
	public void setShiroUser (ShiroUser shiroUser){
		req.getSession().setAttribute("ShiroUser", shiroUser);
	}
	//移除session
	public void remove() {
		req.getSession().removeAttribute("ShiroUser");
		
	}
}
