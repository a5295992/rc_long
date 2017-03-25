package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.SysMenu;

public interface MenuDao {

	List<SysMenu> getMenuList(String hql,String flag);

	List<SysMenu> getMenuListByPid(String menu_pid, String hql2);

}
