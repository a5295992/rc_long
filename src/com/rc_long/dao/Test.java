package com.rc_long.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rc_long.Entity.SysUser;
import com.rc_long.Entity.SysUserInfor;




public class Test {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		List<Class> list=new ArrayList<Class>();
		list.add(SysUser.class);
		list.add(SysUserInfor.class);
		List<String[]> list2=new ArrayList<String[]>();
		String []arr={"user_id","user_name"};
		list2.add(arr);
		list2.add(new String[]{"user_id"});
		List<String> list3=new ArrayList<String>();
		list3.add("t1.user_id = t2.user_id");
		SqlCreate.genenrateLeftJoinQuerySql(list, list2, list3, sb);
		System.out.println(sb.toString().toLowerCase());
	}
}
