package com.rc_long.service.user.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysUser;
import com.rc_long.dao.UserDao;
import com.rc_long.service.user.SysUserService;

@Component
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private UserDao userDao;
	@Override
	public void createUser(SysUser syuser) {
		try {
			userDao.saveUser(syuser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SysUser searchUse(Map<String, Object> map) {
		
		String user_id = (String) map.get("user_ssid");
		
		String password  = (String) map.get("password");
		
		return userDao.getUserById(user_id,password);
	}

}
