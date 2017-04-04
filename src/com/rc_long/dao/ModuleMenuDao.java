package com.rc_long.dao;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.ModuleMenu;

public interface ModuleMenuDao {
	
	/**
	 * 根据 父类id 获取 子集
	 * @param i
	 * @return
	 */
	public abstract List<ModuleMenu> getMenuByPId(int i);

	public abstract List<ModuleMenu> getMenu();

	public abstract ModuleMenu getMenuById(Integer menu_id);

	public abstract void saveOrUpdate(ModuleMenu moduleMenu);

	public abstract void dele(ModuleMenu moduleMenu);
	
	/**
	 * 获取所有的菜单
	 * @param hql
	 * @return
	 */
	public abstract List<ModuleMenu> getAllMenuList(String hql);

	public abstract List<ModuleMenu> getAllMenuList(String hql, Map<String,Object> map);

}
