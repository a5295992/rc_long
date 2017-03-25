package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.SysMenu;

public interface MenuService {

	public  abstract List<SysMenu> getMenu();

	public abstract List<SysMenu> getMenuList(String flag);
}
