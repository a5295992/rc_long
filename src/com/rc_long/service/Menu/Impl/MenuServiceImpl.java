package com.rc_long.service.Menu.Impl;

import com.rc_long.Entity.SysMenu;
import com.rc_long.action.base.BaseServiceImpl;

public class MenuServiceImpl extends BaseServiceImpl<SysMenu>  {
	
	public Class<SysMenu> clazz;
	public MenuServiceImpl(Class<SysMenu> clazz) {
		super(clazz);
		this.clazz=clazz;
	}
}
