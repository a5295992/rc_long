package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.ModuleMenu;
/**
 * 菜单管理
 * @author Administrator
 *
 */
public interface ModuleMenuService {

	
	public List<ModuleMenu> getMenu();
	/**
	 * 根据 id 获取 菜单 类型
	 * @param menu_id
	 * @return
	 */
	public ModuleMenu getMenuById(Integer menu_id);
	
	
	public void dele(ModuleMenu moduleMenu);
	void add(ModuleMenu moduleMenu);
	//查询 所有 没有下上级
	public List<ModuleMenu> getMenu(boolean b);
	
	public List<ModuleMenu> getVideoMenu(int i, boolean b, String string);
	
	public List<ModuleMenu> getVideoMenu(int pid,String c);
	
	//所有在主页显示的菜单
	
	
}
