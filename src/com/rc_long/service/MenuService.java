package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.SysMenu;
/**
 * 菜单 service 
 * @author Administrator
 *
 */
public interface MenuService {

	public  abstract List<SysMenu> getMenu();

	public abstract List<SysMenu> getMenuList(String flag);
}
