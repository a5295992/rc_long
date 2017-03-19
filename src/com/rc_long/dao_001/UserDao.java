package com.rc_long.dao_001;

import com.rc_long.entity_001.User;

public interface UserDao {
	
	/**
	 * 将 user实例保存到数据库
	 * @param u
	 */
	public abstract void save(User u);
	
	/**
	 * 从数据库里面获取User 实例
	 * @param id
	 * @return
	 */
	public abstract User getUser(String id);
}
