package com.rc_long.service.user;

import java.util.Map;

import com.rc_long.Entity.SysUser;

public interface SysUserService {
	
	
	public void createUser(SysUser syuser);
	
	
	public SysUser searchUse(Map<String,Object> map);


	public void updateUser(SysUser user);


	public SysUser searchUserById(String user_id);
}
