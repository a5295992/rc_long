package com.rc_long.test;

import redis.clients.jedis.Jedis;

import com.rc_long.Entity.SysUser;
import com.rc_long.utils.JedisUtils;

public class TestJedisUtils {
	
	public static void main(String[] args) {
		
		SysUser  b= (SysUser) JedisUtils.getObject("session");
		System.out.println(b);
		System.out.println(b.getSession());
		
	}
}
