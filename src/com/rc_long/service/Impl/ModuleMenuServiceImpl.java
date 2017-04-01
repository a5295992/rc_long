package com.rc_long.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.ModuleMenu;
import com.rc_long.dao.ModuleMenuDao;
import com.rc_long.service.ModuleMenuService;

/**
 * 菜单管理
 * 
 * @author Administrator
 * 
 */
@Component
public class ModuleMenuServiceImpl implements ModuleMenuService {
	@Autowired
	private ModuleMenuDao moduleMenuDao;

	// ***************************************************************************
	/**
	 * 获取
	 */
	public List<ModuleMenu> getMenu() {

		List<ModuleMenu> list = getMenuList(0);

		return list;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */

	private List<ModuleMenu> getMenuList(int i) {
		List<ModuleMenu> list = getsortList(i);
		for (ModuleMenu moduleMenu : list) {
			if (moduleMenu.isParent()) {
				moduleMenu.setChildren(getMenuList(moduleMenu.getId()));
			}
		}
		return list;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */

	private List<ModuleMenu> getsortList(int i) {

		return moduleMenuDao.getMenuByPId(i);
	}
	
	/**
	 * 根据 id 获取 菜单类型
	 */
	public ModuleMenu getMenuById(Integer menu_id) {
		
		return moduleMenuDao.getMenuById(menu_id);
	}

	@Override
	public void add(ModuleMenu moduleMenu) {
		
		moduleMenuDao.saveOrUpdate(moduleMenu);
		
	}

	@Override
	public void dele(ModuleMenu moduleMenu) {
		
		moduleMenuDao.dele(moduleMenu);
		
	}

	// ***********************************************************************
	// * ****

	/*
	 * private List<ModuleMenu> getMenuList() {
	 * 
	 * 
	 * return moduleMenuDao.getMenu(); }
	 */
}
