package com.rc_long.test;

import com.rc_long.Entity.User;
import com.rc_long.utils.SpirngIOC;

public class Test_HibenateDataHelper {
	
	
	public static void main(String[] args) {
		
		
		HibenateDataJHelper her = SpirngIOC.getBeanById("hibenateDataJHelper");
		
		
		her.save(new User("long","2323234",11));
		
		System.out.println(her.getById(User.class, "23232"));
	}
}
