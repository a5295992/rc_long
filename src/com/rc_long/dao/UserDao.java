package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.SysUser;

/**
 * 用户数据层
 * userDao
 * @author ZXL
 *
 */
public interface UserDao {
	
	/**
	 * 存储用户信息
	 * @param user
	 */
	public void saveUser(SysUser user);
	
	
	public SysUser getUserById(String userId,String password);
	
	
	public List<SysUser> getUserByHql();


	public void update(SysUser user);


	public SysUser getUserByUserId(String user_id);
	
}
