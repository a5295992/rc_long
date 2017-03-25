package com.rc_long.tldDao;

import java.util.List;

import com.rc_long.Entity.SysMenu;

public interface TLDMenuDao {

	
	
	public List<SysMenu> getMenuList(String sql,Object [] obj);
	
	
	public SysMenu getMenu(String sql,Object [] obj);
}
