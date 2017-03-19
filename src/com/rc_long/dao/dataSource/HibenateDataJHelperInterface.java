package com.rc_long.dao.dataSource;

import com.rc_long.Entity.User;

public interface HibenateDataJHelperInterface {

	
	
	public abstract void save(User user);
	
	
	public abstract void getById(Class<User> clazz,String id);
}
