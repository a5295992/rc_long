package com.rc_long.dao;

import com.rc_long.Entity.User;
import com.rc_long.dao.dataSource.HibenateDataJHelperInterface;

public class HibenateDataJHelper implements HibenateDataJHelperInterface{

	@Override
	public void save(User user) {
		System.out.println("功能正常");
	}

	@Override
	public void getById(Class<User> clazz, String id) {
		
	}
	
	
}
