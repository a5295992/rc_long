package com.rc_long.tldService;

import java.util.List;

import com.rc_long.Entity.SysMenu;


public interface TLDMenuService {
	

	
	public List<SysMenu> getMenuList(String flag);
	
	
	public List<SysMenu> getMenuByPid(String pid);
	
	
	public SysMenu getMenu(String id);
}
