package com.rc_long.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.rc_long.Entity.SysUser;
import com.rc_long.dao.DateBase;
import com.rc_long.utils.Pager;


public class DateBaseInsertTest {
	@Test
	public static void testInert(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", UUID.randomUUID().toString());
		map.put("user_name", "李秋水");
		map.put("user_key", "m123");
		map.put("user_ssid", "m123");
		map.put("user_group", 1);
		map.put("user_type",1 );
		map.put("user_staut", 1);
		map.put("user_flag", 1);
		map.put("user_attr1", "1");
		map.put("user_attr2", "1");
		map.put("session_id", "fsdfasfsf");
		map.put("user_last_time", new java.sql.Date(new Date().getTime()));
		map.put("user_regist_time", new java.sql.Date(new Date().getTime()));
		
		DateBase.insert(SysUser.class, map);
	}
	
	public static void update(){
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> condtion=new HashMap<String,Object>();
		map.put("user_name", "阿里郎");
		condtion.put("user_name","admin");
		DateBase.update(SysUser.class, map,condtion);
	}
	
	public static void delete(){
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("user_name", "许平秋");
		DateBase.delete(SysUser.class, condition);
	}
	
	public static Pager<SysUser> getPager(){
		return DateBase.queryList(SysUser.class, "user_id,user_name", "{user_key:'m123'}","user_id,desc", new Pager<SysUser>(3,3,0), new String[]{"user_key","m"});
	}
	
	public static SysUser getT(){
		return DateBase.querySingle(SysUser.class, "user_id,user_name", "{user_name:'李秋水'}");
	}
	/**
	 * 查询和
	 * @param args
	 */
	public static void getcount(){
		int count =DateBase.queryCount(SysUser.class);
		System.out.println(count);
	}
	public static void main(String[] args) {
		getcount();
	}
	
}
