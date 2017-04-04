package com.rc_long.tldService;

import java.util.List;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.SysMenu;


public interface TLDMenuService {
	

	
	public List<ModuleMenu> getMenuList(Integer i);
	
	
	
	
	public SysMenu getMenu(String id);
}
