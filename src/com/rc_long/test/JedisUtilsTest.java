package com.rc_long.test;

import org.junit.Test;

import com.rc_long.utils.JedisUtils;

public class JedisUtilsTest {

	
	@Test
	public void testJedisSavaObject(){
		
		/*SysUser user= new SysUser();
		
		SysUser user1= new SysUser();
		SysUser user2= new SysUser();
		SysUser user3= new SysUser();
		
		
		List<SysUser> list = new ArrayList<SysUser>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		JedisUtils.saveObject("testList", list);*/
		JedisUtils.clear();
		System.out.println(JedisUtils.getObject("testList"));
	
	}
}
